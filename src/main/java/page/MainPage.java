package page;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class MainPage
{
    protected AndroidDriver driver;
    Utils utils;
    MainScreen screen;
    public MainPage(AndroidDriver driver)
    {
        this.driver = driver;
        utils = new Utils(driver);
        screen = new MainScreen();
    }

    public void clickLoginButton()
    {
        WebElement el = utils.find(screen.LoginButton);
        el.click();
    }

    public void clickSwipeButton()
    {
        WebElement el = utils.find(screen.SwipeButton);
        el.click();
    }
}
