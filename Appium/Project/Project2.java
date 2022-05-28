package Appium.Mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Project2 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void GoogleKeeps() throws InterruptedException {

        Thread.sleep(4000);
       // driver.findElementById("com.google.android.keep:id/add_items_layout").click();
        driver.findElementById("com.google.android.keep:id/new_note_button").click();
        Thread.sleep(4000);
        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Test Title");
        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Test Content");
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        Thread.sleep(2000);
        String title = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
        System.out.println("Title : " + title);

        Assert.assertEquals(title, "Test Title");
        //Thread.sleep(300);


    }
    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}