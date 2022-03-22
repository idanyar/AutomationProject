package workflows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class WebXYZBankManagerFlows extends CommonOps
{
    @Step("Business Flow Manager: Add Customer")
    public static void AddCustomer(String FirstName, String LastName, String PostCode )
    {
        UIActions.click(XYZBankMainPageManager.getBtn_MainAddCustomer());
        UIActions.updateText(XYZBankMainPageManager.getField_firstName(), FirstName);
        UIActions.updateText(XYZBankMainPageManager.getField_LastName(), LastName);
        UIActions.updateText(XYZBankMainPageManager.getField_postCode(), PostCode);
        UIActions.click(XYZBankMainPageManager.getBtn_AddCustomer());
        driver.switchTo().alert().accept();
    }

    @Step("Business Flow Manager: Search and Verify User")
    public static void searchAndVerifyUser(String user, String shouldExist)
     {
        UIActions.updateTextHuman(XYZBankMainPageManager.getTxt_search(), user);
        if (shouldExist.equalsIgnoreCase("exist"))
            Verifications.verifyExistenceOfElement(XYZBankMainPageManager.getRows());
        else if (shouldExist.equalsIgnoreCase("not-exist"))
            Verifications.verifyNonExistenceOfElement(XYZBankMainPageManager.getRows());
        else
            throw new RuntimeException("Invalid Expected Output Option in Data Driven Testing, Should be exist or not-exist");
    }
}
