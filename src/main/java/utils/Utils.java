package utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Utils
{
    WebDriverWait wait;
    public Utils(AndroidDriver driver)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement find(By by)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }



    private static Properties properties = new Properties();

    static {
        try (InputStream input = Utils.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            } else {
                properties.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void loadProperties(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
