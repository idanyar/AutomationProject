package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.testng.Assert.*;

public class Verifications extends CommonOps
{
    @Step("Verify Text in Element")
    public static void verifyTextInElement(WebElement elem, String expected)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Number of Elements")
    public static void numberOfElements(List<WebElement> elems, int expected)
    {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        System.out.println(elems);
        assertEquals(elems.get(elems.size()-1), expected);
    }

    @Step("Verify Visibility of Elements (Soft-Assertion")
    public static void verifyVisibilityOfElements(List<WebElement> elms)
    {
        for(WebElement elem : elms)
        {
            softAsserts.assertTrue(elem.isDisplayed(), "Sorry " + elem.getText() + " not displayed");
        }

        softAsserts.assertAll("Some elements were not displayed");
    }

    @Step ("Verify Element Visually")
    public static void verifyVisualElement(String expectedImageName)
    {
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
             }
            catch (FindFailed findFailed)
            {
            System.out.println("Error Comparing Image File" + findFailed);
            fail();
            }
    }

    @Step ("Verify Element Size")
    public static void verifyExistenceOfElement(List<WebElement> elements)
    {
        assertTrue(elements.size() - 1 > 0);
    }

    @Step ("Verify Element Size")
    public static void verifyNonExistenceOfElement(List<WebElement> elements)
    {
        assertFalse(elements.size() -1  > 0);
    }

    @Step ("Verify Element Display")
    public static void verifyElementDisplay(WebElement elem)
    {
        assertTrue(elem.isDisplayed());
    }


    @Step ("Verify Text with Text")
    public static void verifyText(String actual, String expected)
    {
           assertEquals(actual, expected);
    }

    @Step ("Verify API Status Code")
    public static void verifyStatusCode(int expected)
    {
        int statusCode = response.statusCode();
        assertEquals(statusCode, expected);
    }

    @Step ("Verify Number with Number")
    public static void verifyNumber(int actual,int expected)
    {
        assertEquals(actual, expected);
    }

    @Step("Verify Prices Sort")
    public static void sortPrice(List<WebElement> element)
    {

        List<WebElement> price = (List<WebElement>) element;
        List<Double> prices = new ArrayList<>();
        for (WebElement e : price)
        {
            prices.add(Double.valueOf(e.getText().replace("$","")));
        }
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        System.out.println(sortedPrices.equals(prices));
        System.out.println("Price After Sort: " + sortedPrices);
        assertEquals(prices, sortedPrices);

    }
}

