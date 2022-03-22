package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps
{
    @Step("Calculate Addition 1 + 5")
    public static void calculateAddition()
    {
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_plus());
        UIActions.click(calcMain.getBtn_Five());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Calculate Absolute |-2|")
    public static void calculateAbsoluteValue()
    {
        UIActions.click(calcMain.getBtn_openNavigation());
        UIActions.click(calcMain.getBtn_scientificCalculator());
        UIActions.click(calcMain.getBtn_Seven());
        UIActions.click(calcMain.getBtn_minus());
        UIActions.click(calcMain.getBtn_nine());
        UIActions.click(calcMain.getBtn_equals());
        try
        {
            UIActions.clickOnImage("CalculatorPositive");
        }
        catch (FindFailed findFailed)
        {
            findFailed.printStackTrace();
        }
    }

    @Step("Delete Calculator History")
    public static void deleteHistory()
    {
        UIActions.click(calcMain.getBtn_history());
        UIActions.click(calcMain.getBtn_clearHistory());
    }

    @Step("Calculate multiply 10 * 5")
    public static void calculateMultiply()
    {
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_zero());
        UIActions.click(calcMain.getBtn_multiply());
        UIActions.click(calcMain.getBtn_Five());
        UIActions.click(calcMain.getBtn_equals());
    }
}
