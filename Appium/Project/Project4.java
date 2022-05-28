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

public class Project4 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        
		// Set the Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Initiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void GoogleKeepsBonus() throws InterruptedException {

        Thread.sleep(4000);
        driver.findElementById("com.google.android.keep:id/new_note_button").click();
        Thread.sleep(4000);
        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Test Title");
        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Test Content");
        driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Later today']").click();

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        Thread.sleep(2000);
        String title = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
        System.out.println("Title : " + title);

        Assert.assertEquals(title, "Test Title");
        Assert.assertTrue(driver.findElementById("com.google.android.keep:id/reminder_chip_text").isDisplayed());
            }
    @AfterClass
    public void tearDown() {
        
		// Close app
        driver.quit();
    }

}