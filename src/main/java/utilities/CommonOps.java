package utilities;

import extensions.MobileActions;
import extensions.UIActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.lang.reflect.Method;

public class CommonOps extends Base
{
    /*
    ************************************************************************
    Method Name:getData
    Method Description: this method get the data from xml configuration file
    Method Parameters: String
    Method Return: String
    *************************************************************************
     */
    public static String getData(String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error in reading XML file:" + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("IE"))
            driver = initIEDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else
            throw new RuntimeException("Invalid browser type");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initXYZBank();
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try
        {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e)
        {
            System.out.println("Can not connect to appium server, see details: " + e);
        }
        ManagePages.initSwagLabs();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        TouchAction action = new TouchAction(mobileDriver);
    }

    public static void initAPI()
     {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic("eve.holt@reqres.in", "cityslicka");
     }

//    public static void initDesktop()
//    {
//        dc.setCapability("app", getData("CalculatorApp"));
//        try {
//            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
//        } catch (MalformedURLException e) {
//            System.out.println("Can not Connect to Appium Server, See Details: " + e);
//        }
//        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
//        ManagePages.initTCalculator();
//        action = new Actions(driver);
//    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName)
    {
         Platform = PlatformName;
        if (Platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (Platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (Platform.equalsIgnoreCase("api"))
            initAPI();
        //else if (Platform.equalsIgnoreCase("desktop"))
            //initDesktop();

        else
            throw new RuntimeException("Invalid platform name");
        softAsserts = new SoftAssert();
        screen = new Screen();
        //action = new Actions(mobileDriver);
    }

    @AfterClass
    public void closeSession()
    {
        if(!Platform.equalsIgnoreCase("api"))
        {
        if (!Platform.equalsIgnoreCase("mobile"))
           driver.quit();
        else
             mobileDriver.quit();
    }
    }

    @AfterMethod
    public void afterMethod()
    {
        if (Platform.equalsIgnoreCase("web"))
            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
       else if (Platform.equalsIgnoreCase("mobile"))
        {
            MobileActions.tap(1,SwaglabsMenuMain.getBtn_menu(),500);
            MobileActions.tap(1,SwaglabsMenuMain.getBtn_allItems(),500);
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method)
    {
        if(!Platform.equalsIgnoreCase("api"))
        {
        try
        {
           MonteScreenRecorder.startRecord(method.getName());
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
         if (Platform.equalsIgnoreCase("desktop"))
        {
            UIActions.click(calcMain.getBtn_openNavigation());
            UIActions.click(calcMain.getBtn_standardCalculator());
            UIActions.click(calcMain.getBtn_clear());
        }
         //else
       //mobileDriver.quit();
    }}






