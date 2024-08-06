package test;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;

import java.net.MalformedURLException;

public class SignUpFormTest extends Base
{
    private MainPage mainPage;
    private LoginPage loginPage;
    public SignUpFormTest() throws MalformedURLException
    {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test(description = "Sign Up success")
    public void signUpTest()
    {
        mainPage.clickLoginButton();
        loginPage.clkRegisterBtn();
        loginPage.enterEmail("randomemail@gmail.com");
        loginPage.enterPsw("testpass1234");
        loginPage.enterRepPsw("testpass1234");
        loginPage.clkSignUpBtn();
        Assert.assertEquals(loginPage.getHeaderText(),"Signed Up!");
        Assert.assertEquals(loginPage.getAlertText(),"You successfully signed up!");
        loginPage.clickOk();
    }


    @Test(description = "Sign Up short wrong Email format")
    public void signUpTestInvalidEmail()
    {
        mainPage.clickLoginButton();
        loginPage.clkRegisterBtn();
        loginPage.enterEmail("randomemagmail.com");
        loginPage.enterPsw("testpass1234");
        loginPage.enterRepPsw("testpass1234");
        loginPage.clkSignUpBtn();
        Assert.assertEquals(loginPage.invalidEmailText(),"Please enter a valid email address");
    }


    @Test(description = "Sign Up short password")
    public void signUpTestShortPass()
    {
        mainPage.clickLoginButton();
        loginPage.clkRegisterBtn();
        loginPage.enterEmail("randomemail@gmail.com");
        loginPage.enterPsw("1234");
        loginPage.enterRepPsw("1234");
        loginPage.clkSignUpBtn();
        Assert.assertEquals(loginPage.shortPassMsg(),"Please enter at least 8 characters");
    }

    @Test(description = "Sign Up passwords don't match")
    public void simpleTest()
    {
        mainPage.clickLoginButton();
        loginPage.clkRegisterBtn();
        loginPage.enterEmail("randomemail@gmail.com");
        loginPage.enterPsw("testpass123");
        loginPage.enterRepPsw("testpass1234");
        loginPage.clkSignUpBtn();
        Assert.assertEquals(loginPage.passNoMatchMsg(),"Please enter the same password");
    }

}
