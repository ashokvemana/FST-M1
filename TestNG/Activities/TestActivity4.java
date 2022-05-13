//4. Verify the title of the second most popular course
        //Goal: Read the title of the second most popular course on the website and verify the text
        // a. Open a browser.
        // b. Navigate to ‘https://alchemy.hguy.co/lms’.
        // c. Get the title of the second most popular course.
        // d. Make sure it matches “Email Marketing Strategies” exactly.
        // e. If it matches, close the browser.

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

public class TestActivity4 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void Testcase4() {

        // c. Get the title of the second most popular course.
        WebElement titleText = driver.findElement(By.cssSelector("#post-71 > div:nth-child(3) > h3:nth-child(1)"));

        // d. Make sure it matches “Email Marketing Strategies” exactly.
        Assert.assertEquals(titleText.getText(), "Email Marketing Strategies");
        System.out.println(titleText.getText());

        Reporter.log(titleText.getText());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
