package pageObjects.SwagLabs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage
{
    private AppiumDriver mobileDriver;

    public CartPage(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Sauce Labs Bike Light']")
    private AndroidElement field_productName;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-Amount']")
    private List<WebElement> field_productQTY;

    @AndroidFindBy(xpath ="//*[@bounds='[868,1095][1028,1255]']")
    private AndroidElement btn_swipeRemove;

    @AndroidFindBy(xpath ="//*[@contentDescription='test-CHECKOUT']")
    private AndroidElement btn_Checkout;

    @AndroidFindBy(xpath ="//*[@contentDescription='test-CONTINUE SHOPPING']")
    private AndroidElement btn_continueShopping;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-First Name']")
    private AndroidElement field_FirstName;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-Last Name']")
    private AndroidElement field_LastName;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-Zip/Postal Code']")
    private AndroidElement field_PostalCode;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-CONTINUE']")
    private AndroidElement btn_Continue;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-CANCEL']")
    private AndroidElement btn_Cancel;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-FINISH']")
    private AndroidElement btn_Finish;

    @AndroidFindBy(xpath = "//*[@text='Your order has been dispatched, and will arrive just as fast as the pony can get there!']")
    private AndroidElement field_orderSuccess;

    public AndroidElement getField_productName()
    {
        return field_productName;
    }

    public List<WebElement> getField_productQTY()
    {
        return field_productQTY;
    }

    public AndroidElement getBtn_swipeRemove()
    {
        return btn_swipeRemove;
    }

    public AndroidElement getBtn_continueShopping()
    {
        return btn_continueShopping;
    }

    public AndroidElement getBtn_Checkout()
    {
        return btn_Checkout;
    }

    public AndroidElement getField_FirstName()
    {
        return field_FirstName;
    }

    public AndroidElement getField_LastName()
    {
        return field_LastName;
    }

    public AndroidElement getField_PostalCode()
    {
        return field_PostalCode;
    }

    public AndroidElement getBtn_Cancel()
    {
        return btn_Cancel;
    }

    public AndroidElement getBtn_Finish()
    {
        return btn_Finish;
    }

    public AndroidElement getField_orderSuccess()
    {
        return field_orderSuccess;
    }

    public AndroidElement getBtn_Continue()
    {
        return btn_Continue;
    }
}

