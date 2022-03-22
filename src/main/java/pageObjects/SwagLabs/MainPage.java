package pageObjects.SwagLabs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage
{
    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(xpath ="//*[@text='PRODUCTS']")
    private AndroidElement txt_Title;

    @AndroidFindBy(xpath = "//*[@text='ADD TO CART' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Sauce Labs Bike Light']]]")
    private AndroidElement btn_AddToCartProduct;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[./parent::*[@contentDescription='test-Modal Selector Button']]]]\n")
    private AndroidElement btn_sort;

    @AndroidFindBy(xpath = "//*[@text='Price (low to high)']")
    private AndroidElement btn_lowToHigh;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@contentDescription='test-Cart']]]")
    private AndroidElement btn_Cart;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-Price']")
    private List<WebElement> field_Prices;

    public AndroidElement getTxt_Title()
    {
        return txt_Title;
    }

    public AndroidElement getBtn_AddToCartProduct()
    {
        return btn_AddToCartProduct;
    }

    public AndroidElement getBtn_sort()
    {
        return btn_sort;
    }

    public AndroidElement getBtn_lowToHigh()
    {
        return btn_lowToHigh;
    }

    public AndroidElement getBtn_Cart()
    {
        return btn_Cart;
    }

    public List<WebElement> getField_Prices()
    {
        return field_Prices;
    }
}


