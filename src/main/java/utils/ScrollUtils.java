package utils;




import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.NoSuchElementException;




import java.time.Duration;
import java.util.Arrays;

public class ScrollUtils {

    Utils utils;
    private AndroidDriver driver;
    public ScrollUtils(AndroidDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }


    public void swipe(int startX, int startY, int endX, int endY, int durationInSeconds) {



        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");


        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(durationInSeconds * 1000), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        driver.perform(Arrays.asList(swipe));
    }

    public void scrollIntoView(By locator)
    {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int x = width/2;
        int topY = height/5;
        int botY = height/3;
        int botTopY = height-height/3;
        int botBotY = height-height/6;
        boolean found = false;
        WebElement el;
        int scroll_number = 0;
        while(!found)
        {


            try
            {
                el = driver.findElement(locator);
                found = el.isDisplayed();
                break;
            }
            catch (NoSuchElementException e)
            {
                swipe(x,botY,x,topY,1);
                scroll_number++;
                swipe(x,botBotY,x,botTopY,1);
                scroll_number++;
                System.out.println("scrolling...");
            }
            if(scroll_number>30)
            {
                scroll_number=0;
                break;
            }
        }

        while(!found)
        {


            try
            {
                el = driver.findElement(locator);
                found =  el.isDisplayed();
                break;
            }
            catch (NoSuchElementException e)
            {
                swipe(x,topY,x,botY,1);
                scroll_number++;
                swipe(x,botTopY,x,botBotY,1);
                scroll_number++;
                System.out.println("scrolling...");
            }
            if(scroll_number>30)
            {
                scroll_number=0;
                break;
            }
        }

    }
}

