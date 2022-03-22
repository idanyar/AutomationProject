package pageObjects.XYZBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class MainPageManager
{
    @FindBy(how = How.TAG_NAME, using = "tr")
    private List<WebElement> rows;

    @FindBy(how = How.CSS, using = "input[placeholder='Search Customer']")
    private WebElement txt_search;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    private WebElement btn_MainAddCustomer;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    private WebElement btn_OpenAccount;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[1]/button[3]")
    private WebElement btn_Customers;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")
    private WebElement Field_firstName;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")
    private WebElement Field_LastName;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")
    private WebElement Field_postCode;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button")
    private WebElement btn_AddCustomer;

    public List<WebElement> getRows()
    {
        return rows;
    }

    public WebElement getTxt_search()
    {
        return txt_search;
    }

    public WebElement getBtn_MainAddCustomer()
    {
        return btn_MainAddCustomer;
    }

    public WebElement getBtn_OpenAccount()
    {
        return btn_OpenAccount;
    }

    public WebElement getBtn_Customers() { return btn_Customers; }

    public WebElement getField_firstName()
    {
        return Field_firstName;
    }

    public WebElement getField_LastName ()
    {
        return Field_LastName;
    }

    public WebElement getField_postCode ()
    {
        return Field_postCode;
    }

    public WebElement getBtn_AddCustomer ()
    {
        return btn_AddCustomer;
    }
}
