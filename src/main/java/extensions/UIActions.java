package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Update Text Element as Human")
    public static void updateTextHuman(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch : text.toCharArray())
        {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        elem.sendKeys(ch + "");
        }
    }

    @Step("Click on Element and Send Keys")
    public static void clickUpdate(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
        elem.sendKeys(text);
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

     @Step("Mouse Hover Element")
     public static void mouseHover(WebElement elem1, WebElement elem2)
     {
         action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
     }

     @Step("Insert Key")
     public static void insertKey(WebElement elem, Keys value)
     {
         elem.sendKeys(Keys.RETURN);
     }

    @Step("Click on Image")
    public static void clickOnImage(String expectedImageName) throws FindFailed
    {
        screen.click(getData("ImageRepo") + expectedImageName + ".png");
    }
 }