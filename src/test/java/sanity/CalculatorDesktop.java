package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps
{
    @Test(description = "Test 01: Verify Addition Command")
    @Description("This Test Verifies the Addition Command")
    public void test01_verifyAdditionAction()
    {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.getField_result(), "Display is 6");
    }

    @Test(description = "Test 02: Verify Absolute Command")
    @Description("This Test Verifies Absolute Command")
    public void test02_verifyAbsoluteAction()
    {
       DesktopFlows.calculateAbsoluteValue();
       Verifications.verifyTextInElement(calcMain.getField_result(),"Display is 2");
    }

    @Test(description = "Test 03: Verify History Memory Deletion")
    @Description("This Test Perform Multiply Command and Delete the Activity from History")
    public void test03_verifyHistoryDeletionAction() throws FindFailed
    {
        DesktopFlows.calculateMultiply();
        DesktopFlows.deleteHistory();
        Verifications.verifyElementDisplay(calcMain.getField_noHistory());
        UIActions.clickOnImage("CalculatorHistory");
    }
}
