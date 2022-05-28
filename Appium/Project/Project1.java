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

public class Project1 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void GoogleTasks() throws InterruptedException {

        Thread.sleep(4000);
        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();

        Thread.sleep(2000);
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Test Title");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_change_details").click();
        Thread.sleep(2000);
        driver.findElementById("com.google.android.apps.tasks:id/add_task_details").sendKeys("Test Details");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        Thread.sleep(4000);
        String taskName = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
        System.out.println("Task:  " + taskName );

        Assert.assertEquals(taskName, "Test Title");
        //Thread.sleep(300);
        driver.findElementById("com.google.android.apps.tasks:id/task_name").click();
        Thread.sleep(2000);
        driver.findElementById("com.google.android.apps.tasks:id/delete_task_option").click();

    }
     @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}