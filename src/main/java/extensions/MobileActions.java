package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.Screen;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;

public class MobileActions extends CommonOps
{
    @Step("Tap on Element")
    public static void tap(int fingers, MobileElement elem, int duration)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        mobileDriver.tap(fingers, elem, duration);
    }

    @Step("Swipe")
    public static void swipe(int startX, int startyY, int endx, int endY, int duration)
    {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        mobileDriver.swipe(startX, startyY,endx, endY, duration);
    }

    @Step("Zoom on Element")
    public static void zoom(MobileElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        mobileDriver.zoom(elem);
    }

    @Step("pinch Element")
    public static void pinch(MobileElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        mobileDriver.pinch(elem);
    }

    @Step("Update Text Element")
    public static void updateText(MobileElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
}




