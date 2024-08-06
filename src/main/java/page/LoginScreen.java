package page;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginScreen
{
    By EmailField = AppiumBy.accessibilityId("input-email");
    By PasswField = AppiumBy.accessibilityId("input-password");
    By RepeatPassField = AppiumBy.accessibilityId("input-repeat-password");
    By RegisterBtn =  AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(11)");
    By SignUpBtn = AppiumBy.accessibilityId("button-SIGN UP");
    By AlertHeader = AppiumBy.id("android:id/alertTitle");
    By AlertMessage = AppiumBy.id("android:id/message");
    By InvalidEmailMsg = AppiumBy.androidUIAutomator("new UiSelector().text(\"Please enter a valid email address\")");
    By InvalidPassMsg = AppiumBy.androidUIAutomator("new UiSelector().text(\"Please enter at least 8 characters\")");
    By InvalidResetPassMsg = AppiumBy.androidUIAutomator("new UiSelector().text(\"Please enter the same password\")");
    By AlertOKBtn = AppiumBy.id("android:id/button1");
}
