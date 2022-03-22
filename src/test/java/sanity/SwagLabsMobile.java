package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extensions.MobileActions;
import extensions.Verifications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class SwagLabsMobile extends CommonOps
{
    @Test(description = "Test01: Login To APP Main Page")
    @Description("This Test login to APP and verifies Main Page Title")
    public void test01_verifyHeader()
    {
        MobileFlows.login("standard_user", "secret_sauce");
        Verifications.verifyTextInElement(SwaglabsMainPage.getTxt_Title(), "PRODUCTS");
    }

    @Test(description = "Test02: Add Product to Cart and Verify it")
    @Description("This Test Add New Product to the Cart and Verifies it")
    public void test02_verifyProductInCart()
    {
        MobileFlows.addProductToCart();
        Verifications.verifyTextInElement(SwaglabsCartPage.getField_productName(),"Sauce Labs Bike Light");
    }

    @Test(description = "Test03: Remove Product From Cart")
    @Description("This Test Remove Product from Cart Using Button Reveals After Swipe")
    public void test03_removeProductFromCart()
    {
        MobileActions.tap(1,SwaglabsMainPage.getBtn_Cart(),500);
        MobileActions.swipe(1019,1200,783,1205,260);
        MobileActions.tap(1,SwaglabsCartPage.getBtn_swipeRemove(), 500);
        Verifications.verifyNonExistenceOfElement(SwaglabsCartPage.getField_productQTY());
    }

    @Test(description = "Test04: Purchase New Product")
    @Description("This Test Completes Purchase Process and Verifies Success")
    public void test04_purchaseProduct()
    {
        MobileFlows.addProductToCart();
        MobileFlows.buyProduct("Avi", "Cohen", "01");
        Verifications.verifyTextInElement(SwaglabsCartPage.getField_orderSuccess(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @Test(description = "Test05: Sort Product Prices")
    @Description("This Test Sort Products Prices From Low to High")
    public void test05_sortProductsPrices()
    {
        MobileFlows.presentPrices(SwaglabsMainPage.getField_Prices());
        MobileActions.tap(1,SwaglabsMainPage.getBtn_sort(),500);
        MobileActions.tap(1,SwaglabsMainPage.getBtn_lowToHigh(),500);
        Verifications.sortPrice(SwaglabsMainPage.getField_Prices());
    }
}
