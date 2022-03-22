package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.XYZBank.MainPageCustomer;
import pageObjects.XYZBank.MainPageManager;

public class ManagePages extends Base
{
    public static void initXYZBank()
    {
        XYZBankOpenPage = PageFactory.initElements(driver, pageObjects.XYZBank.OpenPage.class );
        XYZBankMainPageCustomer = PageFactory.initElements(driver, MainPageCustomer.class);
        XYZBankMainPageManager = PageFactory.initElements(driver, MainPageManager.class);
    }

    public static void initSwagLabs()
    {
        SwaglabsLogin = new pageObjects.SwagLabs.LoginPage(mobileDriver);
        SwaglabsMainPage = new pageObjects.SwagLabs.MainPage(mobileDriver);
        SwaglabsCartPage = new pageObjects.SwagLabs.CartPage(mobileDriver);
        SwaglabsMenuMain = new pageObjects.SwagLabs.MenuMain(mobileDriver);

    }

    public static void initTCalculator()
    {
        calcMain =  PageFactory.initElements(driver, pageObjects.Calculator.MainPage.class);
    }
}
