package pageObjects.SwagLabs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class MenuMain
{
    private AppiumDriver mobileDriver;

    public MenuMain(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@contentDescription='test-Menu']]]")
    private AndroidElement btn_menu;

    @AndroidFindBy(xpath = "//*[@text='ALL ITEMS']")
    private AndroidElement btn_allItems;

    public AndroidElement getBtn_menu()
    {
        return btn_menu;
    }

    public AndroidElement getBtn_allItems()
    {
        return btn_allItems;
    }
}


