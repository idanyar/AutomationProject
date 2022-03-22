package workflows;
import extensions.MobileActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;
import java.util.ArrayList;
import java.util.List;

public class MobileFlows extends CommonOps
{
    @Step("Business Flow: Login")
    public static void login(String username, String password)
    {
        MobileActions.tap(1, SwaglabsLogin.getTxt_Username(), 500);
        MobileActions.updateText(SwaglabsLogin.getTxt_Username(), username);
        MobileActions.tap(1, SwaglabsLogin.getTxt_Password(), 500);
        MobileActions.updateText(SwaglabsLogin.getTxt_Password(), password);
        MobileActions.tap(1, SwaglabsLogin.getBtn_Login(), 500);
    }

    @Step("Business Flow: Add Product to Cart")
    public static void addProductToCart()
    {
        MobileActions.tap(1, SwaglabsMainPage.getBtn_AddToCartProduct(), 500);
        MobileActions.tap(1, SwaglabsMainPage.getBtn_Cart(), 500);
    }

    @Step("Business Flow: Buy Product")
    public static void buyProduct(String FirstName, String LastName, String PostalCode)
    {
        MobileActions.tap(1, SwaglabsCartPage.getBtn_Checkout(), 500);
        MobileActions.updateText(SwaglabsCartPage.getField_FirstName(), FirstName);
        MobileActions.updateText(SwaglabsCartPage.getField_LastName(), LastName);
        MobileActions.updateText(SwaglabsCartPage.getField_PostalCode(), PostalCode);
        MobileActions.tap(1, SwaglabsCartPage.getBtn_Continue(), 500);
        MobileActions.swipe(516,1133,516,316,250);
        MobileActions.swipe(516,1133,516,316,250);
        MobileActions.tap(1,SwaglabsCartPage.getBtn_Finish(), 500);
    }

    @Step("Business Flow: Present Products Prices")
    public static void presentPrices(List<WebElement> element)
    {
        MobileActions.swipe(527,2033,444,1130,260);
        List<WebElement> price = (List<WebElement>) element;
        List<Double> prices = new ArrayList<>();
        for (WebElement e : price)
        {
            prices.add(Double.valueOf(e.getText().replace("$","")));
        }
        System.out.println("Price Before Sort: " + prices);
    }
}
