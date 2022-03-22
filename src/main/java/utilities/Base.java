package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.XYZBank.MainPageCustomer;
import pageObjects.XYZBank.MainPageManager;

public class Base
{
    //General
    protected static WebDriverWait wait;
    protected static SoftAssert softAsserts;
    protected static Screen screen;
    protected static Actions action;
    protected static String Platform;

    // Web
    protected static WebDriver driver;
    protected static pageObjects.XYZBank.OpenPage XYZBankOpenPage;
    protected static MainPageCustomer XYZBankMainPageCustomer;
    protected static MainPageManager XYZBankMainPageManager;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    // Page Objects -  Mobile
    protected static pageObjects.SwagLabs.LoginPage SwaglabsLogin;
    protected static pageObjects.SwagLabs.MainPage SwaglabsMainPage;
    protected static pageObjects.SwagLabs.CartPage SwaglabsCartPage;
    protected static pageObjects.SwagLabs.MenuMain SwaglabsMenuMain;

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Page Objects -  Desktop
    protected static pageObjects.Calculator.MainPage calcMain;
}
