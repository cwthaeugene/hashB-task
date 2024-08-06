package test;

import base.Base;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.MainPage;
import utils.ScrollUtils;


import java.net.MalformedURLException;

public class ScrollTest extends Base
{
    private MainPage mainPage;

    ScrollUtils scrollUtils;
    public ScrollTest() throws MalformedURLException
    {
        scrollUtils = new ScrollUtils(driver);
        mainPage = new MainPage(driver);

    }


    @Test(description = "ScrollTest")
    public void scrollTest()
    {
        mainPage.clickSwipeButton();
        By locator = AppiumBy.androidUIAutomator("new UiSelector().text(\"You found me!!!\")");
        scrollUtils.scrollIntoView(locator);
    }

}
