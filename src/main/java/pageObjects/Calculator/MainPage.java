package pageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage
{
    @FindBy(how = How.NAME, using = "One")
    private WebElement btn_one;

    @FindBy(how = How.NAME, using = "Two")
    private WebElement btn_Two;

    @FindBy(how = How.NAME, using = "Three")
    private WebElement btn_three;

    @FindBy(how = How.NAME, using = "Four")
    private WebElement btn_four;

    @FindBy(how = How.NAME, using = "Five")
    private WebElement btn_Five;

    @FindBy(how = How.NAME, using = "Six")
    private WebElement btn_six;

    @FindBy(how = How.NAME, using = "Seven")
    private WebElement btn_Seven;

    @FindBy(how = How.NAME, using = "Eight")
    private WebElement btn_eight;

    @FindBy(how = How.NAME, using = "Nine")
    private WebElement btn_nine;

    @FindBy(how = How.NAME, using = "Zero")
    private WebElement btn_zero;

    @FindBy(how = How.NAME, using = "Plus")
    private WebElement btn_plus;

    @FindBy(how = How.NAME, using = "Minus")
    private WebElement btn_minus;

    @FindBy(how = How.NAME, using = "Multiply by")
    private WebElement btn_multiply;

    @FindBy(how = How.NAME, using = "Divide by")
    private WebElement btn_divide;

    @FindBy(how = How.NAME, using = "Equals")
    private WebElement btn_equals;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    private WebElement field_result;

    @FindBy(how = How.NAME, using = "Clear")
    private WebElement btn_clear;

    @FindBy(how = How.NAME, using = "Square")
    private WebElement btn_square;

    @FindBy(how = How.NAME, using = "Open Navigation")
    private WebElement btn_openNavigation;

    @FindBy(how = How.NAME, using = "Close Navigation")
    private WebElement btn_closeNavigation;

    @FindBy(how = How.NAME, using = "Scientific Calculator")
    private WebElement btn_scientificCalculator;

    @FindBy(how = How.NAME, using = "Standard Calculator")
    private WebElement btn_standardCalculator;

    @FindBy(how = How.NAME, using = "Function")
    private WebElement btn_Function;

    @FindBy(how = How.NAME, using = "Open history flyout")
    private WebElement btn_history;

    @FindBy(how = How.NAME, using = "Clear all history")
    private WebElement btn_clearHistory;

    @FindBy(how = How.CLASS_NAME, using = "TextBlock")
    private WebElement field_noHistory;

    public WebElement getBtn_one()
    {
        return btn_one;
    }

    public WebElement getBtn_Two()
    {
        return btn_Two;
    }

    public WebElement getBtn_three()
    {
        return btn_three;
    }

    public WebElement getBtn_four()
    {
        return btn_four;
    }

    public WebElement getBtn_Five()
    {
        return btn_Five;
    }

    public WebElement getBtn_six()
    {
        return btn_six;
    }

    public WebElement getBtn_Seven()
    {
        return btn_Seven;
    }

    public WebElement getBtn_eight()
    {
        return btn_eight;
    }

    public WebElement getBtn_nine()
    {
        return btn_nine;
    }

    public WebElement getBtn_zero()
    {
        return btn_zero;
    }

    public WebElement getBtn_plus()
    {
        return btn_plus;
    }

    public WebElement getBtn_minus()
    {
        return btn_minus;
    }

    public WebElement getBtn_multiply()
    {
        return btn_multiply;
    }

    public WebElement getBtn_divide()
    {
        return btn_divide;
    }

    public WebElement getBtn_equals()
    {
        return btn_equals;
    }

    public WebElement getBtn_clear()
    {
        return btn_clear;
    }

    public WebElement getField_result()
    {
        return field_result;
    }

    public WebElement getBtn_square()
    {
        return btn_square;
    }

    public WebElement getBtn_openNavigation() { return btn_openNavigation; }

    public WebElement getBtn_closeNavigation()
    {
        return btn_closeNavigation;
    }

    public WebElement getBtn_scientificCalculator()
    {
        return btn_scientificCalculator;
    }

    public WebElement getBtn_standardCalculator()
    {
        return btn_standardCalculator;
    }

    public WebElement getBtn_Function()
    {
        return btn_Function;
    }

    public WebElement getBtn_history()
    {
        return btn_history;
    }

    public WebElement getBtn_clearHistory()
    {
        return btn_clearHistory;
    }

    public WebElement getField_noHistory()
    {
        return field_noHistory;
    }
}
