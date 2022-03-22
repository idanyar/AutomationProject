package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extensions.UIActions;
import extensions.Verifications;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebXYZBankManagerFlows;
import workflows.WebXYZVBankCustomerFlows;

@Listeners(utilities.Listeners.class)
    public class XYZBankWeb extends CommonOps
{
    @Test(description = "Test01: Verify Customer Accounts")
    @Description("This Test Login to Customer Account and Verifies his Accounts Number")
    public void test01_verifyAccount()
    {
        WebXYZVBankCustomerFlows.login("Ron Weasly");
        Verifications.verifyTextInElement(XYZBankMainPageCustomer.getField_accountNumber(), "1007" + '\n' + "1008" + '\n' + "1009");
    }

    @Test(description = "Test02: Verify Deposit Action")
    @Description("This Test Switch Account, Deposits Money and Verifies Action")
    public void test02_verifyDeposit()
    {
        UIActions.click(XYZBankMainPageCustomer.getField_accountNumber());
        UIActions.updateDropDown(XYZBankMainPageCustomer.getField_accountNumber(), "1008");
        WebXYZVBankCustomerFlows.deposit("200");
        Verifications.verifyTextInElement(XYZBankMainPageCustomer.getTxt_balance(), "200");
    }

    @Test(description = "test03: Verify Withdrawal Transaction Failed")
    @Description("This Test  Withdrawal Money from Account with no Balance and Verifies Fail Message")
    public void test03_verifyFailMessage()
    {
        UIActions.click(XYZBankMainPageCustomer.getField_accountNumber());
        UIActions.updateDropDown(XYZBankMainPageCustomer.getField_accountNumber(), "1009");
        WebXYZVBankCustomerFlows.withdrawal("500");
        Verifications.verifyVisualElement("webErrorMessage");
    }

        @Test(description = "Test04: Add New Customer")
        @Description("This Test login into Manager Account and Add New Customer")
        public void test04_verifyNewCustomer()
        {
        UIActions.click(XYZBankMainPageCustomer.getBtn_home());
        UIActions.click(XYZBankOpenPage.getBtn_bankManagerLogin());
        UIActions.click(XYZBankMainPageManager.getBtn_Customers());
        System.out.println("Current Customers count: " + XYZBankMainPageManager.getRows().size());
        WebXYZBankManagerFlows.AddCustomer("Omer", "Brosh", "103");
        UIActions.click(XYZBankMainPageManager.getBtn_Customers());
        Assert.assertEquals(XYZBankMainPageManager.getRows().size(),7);
        System.out.println("Current Customers count: " + XYZBankMainPageManager.getRows().size());
    }

        @Test(description = "Test05: Search Customer", dataProvider = "Data Provider-Customers", dataProviderClass = utilities.ManageDDT.class)
        @Description("This Test Search Customers in Customers Table Using DDT")
        public void test05_searchCustomer(String user, String shouldExist)
        {
            UIActions.click(XYZBankMainPageCustomer.getBtn_home());
            UIActions.click(XYZBankOpenPage.getBtn_bankManagerLogin());
            UIActions.click(XYZBankMainPageManager.getBtn_Customers());
            WebXYZBankManagerFlows.searchAndVerifyUser(user, shouldExist);
        }
}




