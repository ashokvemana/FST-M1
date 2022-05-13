package Project_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActivity2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver and open the webpage in the browser
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void Testcase2() {
        //Find the heading of the webpage using css selector
        WebElement headingText = driver.findElement(By.cssSelector("h1.uagb-ifb-title"));

        // Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(headingText.getText(), "Learn from Industry Experts");

        Reporter.log(headingText.getText());

        //print the heading of the webpage
        System.out.println("The Heading of the webpage is === " +headingText.getText());

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}