//3. Verify the title of the first info box
       // Goal: Read the title of the first info box on the website and verify the text
       // a. Open a browser.
       // b. Navigate to ‘https://alchemy.hguy.co/lms’.
       // c. Get the title of the first info box.
       // d. Make sure it matches “Actionable Training” exactly.
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

public class TestActivity3 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        //Open browser
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void Testcase3() {

        //Get the title of the first info box.
        WebElement titleText = driver.findElement(By.cssSelector("#uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3:nth-child(1)"));

        //Make sure it matches “Actionable Training” exactly.
        Assert.assertEquals(titleText.getText(), "Actionable Training");
        System.out.println( "1st Infobox title is: " + titleText.getText());

        Reporter.log(titleText.getText());

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
