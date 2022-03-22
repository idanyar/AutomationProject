package pageObjects.SwagLabs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class LoginPage
{
    private AppiumDriver mobileDriver;

    public LoginPage(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(xpath = "//*[@contentDescription='test-Username']")
    private AndroidElement txt_Username;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-Password']")
    private AndroidElement txt_Password;

    @AndroidFindBy(xpath = "//*[@text='LOGIN']")
    private
    AndroidElement btn_Login;

    public AndroidElement getTxt_Username()
    {
        return txt_Username;
    }

    public AndroidElement getTxt_Password()
    {
        return txt_Password;
    }

    public AndroidElement getBtn_Login()
    {
        return btn_Login;
    }
}
