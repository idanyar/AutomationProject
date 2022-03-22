package pageObjects.XYZBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageCustomer
{
    @FindBy(how = How.ID, using = "accountSelect")
    private   WebElement field_accountNumber;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[3]/button[2]")
    private WebElement btn_depositMain;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[4]/div/form/div/input")
    private WebElement field_amountDeposited;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
    private WebElement btn_deposit;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[3]/button[3]")
    private WebElement btn_withdrawalMain;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
    private WebElement btn_withdrawal;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[2]/strong[2]")
    private WebElement txt_balance;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[1]/button[1]")
    private WebElement btn_home;

    public WebElement getField_accountNumber()
    {
        return field_accountNumber;
    }

    public WebElement getBtn_depositMain()
    {
        return btn_depositMain;
    }

    public WebElement getField_amountDeposited()
    {
        return field_amountDeposited;
    }

    public WebElement getBtn_deposit()
    {
        return btn_deposit;
    }

    public WebElement getBtn_withdrawalMain()
    {
        return btn_withdrawalMain;
    }

    public WebElement getBtn_withdrawal()
    {
        return btn_withdrawal;
    }

    public WebElement getTxt_balance() { return txt_balance; }

    public WebElement getBtn_home() { return btn_home; }
}
