package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class WebXYZVBankCustomerFlows  extends CommonOps
{
    @Step("Business Flow Customer: Login")
    public static void login(String name)
    {
        UIActions.click(XYZBankOpenPage.getBtn_customerLogin());
        UIActions.click(XYZBankOpenPage.getBtn_yourName());
        UIActions.updateDropDown(XYZBankOpenPage.getBtn_yourName(), name);
        UIActions.click(XYZBankOpenPage.getBtn_login());
    }

    @Step("Business Flow Customer: Customer Deposit")
    public static void deposit(String amount)
    {
        System.out.println("Account Balance Before Deposit is:" + XYZBankMainPageCustomer.getTxt_balance().getText());
        UIActions.click(XYZBankMainPageCustomer.getBtn_depositMain());
        UIActions.clickUpdate(XYZBankMainPageCustomer.getField_amountDeposited(), amount);
        UIActions.click(XYZBankMainPageCustomer.getBtn_deposit());
        System.out.println("Account Balance After Deposit is:" + XYZBankMainPageCustomer.getTxt_balance().getText());
    }

    @Step("Business Flow Customer: Deposit")
    public static void withdrawal(String amount)
    {
        UIActions.click(XYZBankMainPageCustomer.getBtn_withdrawalMain());
        UIActions.clickUpdate(XYZBankMainPageCustomer.getField_amountDeposited(), amount);
        UIActions.click(XYZBankMainPageCustomer.getBtn_deposit());
    }
}
