//5. Navigate to another page
        //Goal: Navigate to the “My Account” page on the site.
        // a. Open a browser.
        // b. Navigate to ‘https://alchemy.hguy.co/lms’.
        // c. Find the navigation bar.
        // d. Select the menu item that says “My Account” and click it.
        // e. Read the page title and verify that you are on the correct page.
        // f. Close the browser.

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

public class TestActivity5 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void Testcase5() {

        // d. Select the menu item that says “My Account” and click it.
        WebElement myAccount = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/my-account/']"));
        myAccount.click();

        // e. Read the page title and verify that you are on the correct page.
        WebElement myAccountText = driver.findElement(By.cssSelector("h1.uagb-ifb-title"));
        Assert.assertTrue(myAccountText.isDisplayed());

        Reporter.log(myAccountText.getText());

        System.out.println("New page title is: " + myAccountText.getText());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
        Reporter.getCurrentTestResult();

    }
}
