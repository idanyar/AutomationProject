package pageObjects.XYZBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OpenPage
{
    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[1]/div[1]/button")
    private WebElement btn_customerLogin;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[1]/div[2]/button")
    private WebElement btn_bankManagerLogin;

    @FindBy(how = How.ID, using = "userSelect")
    private WebElement btn_yourName;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/form/button")
    private WebElement btn_login;



    public WebElement getBtn_customerLogin()
    {
        return btn_customerLogin;
    }

    public WebElement getBtn_bankManagerLogin()
    {
        return btn_bankManagerLogin;
    }

    public WebElement getBtn_yourName()
    {
        return btn_yourName;
    }

    public WebElement getBtn_login()
    {
        return btn_login;
    }


}
