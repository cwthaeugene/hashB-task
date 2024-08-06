package base;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import utils.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base
{


    String udid = Utils.getProperty("udid");
    String serverUrl = Utils.getProperty("appium.server.url");
    public static AndroidDriver driver;
    String resourcePath = "android.wdio.native.app.v1.0.8.apk";
    public Base() throws MalformedURLException
    {

        URL resourceURL = Base.class.getClassLoader().getResource(resourcePath);

        if(resourceURL !=null)
        {

            File file = new File(resourceURL.getFile());
            String apkPath = file.getAbsolutePath();
            UiAutomator2Options options = new UiAutomator2Options()
                    .setUdid(udid)
                    .setApp(apkPath);
            driver = new AndroidDriver(new URL(serverUrl), options);

        }
        else
        {
            System.out.println("APK file not found.");
        }
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
