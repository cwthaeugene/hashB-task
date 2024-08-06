package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class LoginPage
{
    protected AndroidDriver driver;
    Utils utils;
    LoginScreen screen;
    public LoginPage(AndroidDriver driver)
    {
        this.driver = driver;
        utils = new Utils(driver);
        screen = new LoginScreen();
    }


    public void enterEmail(String Email)
    {
        WebElement el = utils.find(screen.EmailField);
        el.sendKeys(Email);
    }

    public void clkRegisterBtn()
    {
        WebElement el = utils.find(screen.RegisterBtn);
        el.click();
    }

    public void enterPsw(String password)
    {
        WebElement el = utils.find(screen.PasswField);
        el.sendKeys(password);
    }

    public void enterRepPsw(String password)
    {
        WebElement el = utils.find(screen.RepeatPassField);
        el.sendKeys(password);
    }

    public void clkSignUpBtn()
    {
        WebElement el = utils.find(screen.SignUpBtn);
        el.click();
    }

    public String getHeaderText()
    {
        WebElement el = utils.find(screen.AlertHeader);
        return el.getText();
    }

    public String getAlertText()
    {
        WebElement el = utils.find(screen.AlertMessage);
        return el.getText();
    }

    public String invalidEmailText()
    {
        WebElement el = utils.find(screen.InvalidEmailMsg);
        return el.getText();
    }

    public String shortPassMsg()
    {
        WebElement el = utils.find(screen.InvalidPassMsg);
        return el.getText();
    }

    public String passNoMatchMsg()
    {
        WebElement el = utils.find(screen.InvalidResetPassMsg);
        return el.getText();
    }

    public void clickOk()
    {
        WebElement el = utils.find(screen.AlertOKBtn);
        el.click();
    }
}
