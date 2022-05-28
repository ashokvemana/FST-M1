package Appium.Mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class Project3 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        
		// Set the Required Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Initiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 80);

        // Navigate to the page
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void AddTasksChrome() throws InterruptedException {

        Thread.sleep(4000);
        driver.findElementByXPath("//android.widget.Button[@text='Get Started!']").click();
        Thread.sleep(1000);
      

        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).flingToEnd(3)"));
        driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
        Thread.sleep(1000);
    
        driver.findElement(MobileBy.id("taskInput")).sendKeys("Test");
       
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
        Thread.sleep(6000);
        Assert.assertTrue(driver.findElementById("tasksList").isDisplayed());
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}