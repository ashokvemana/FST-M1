//6. Logging into the site
        //Goal: Open the website and log-in using the provided credentials.
        // a. Open a browser.
        // b. Navigate to ‘https://alchemy.hguy.co/lms’.
        // c. Find the navigation bar.
        // d. Select the menu item that says “My Account” and click it.
        // e. Read the page title and verify that you are on the correct page.
        // f. Find the “Login” button on the page and click it.
        // g. Find the username field of the login form and enter the username into that field.
        // h. Find the password field of the login form and enter the password into that field.
        // i. Find the login button and click it.
        // j. Verify that you have logged in.
        // k. Close the browser.

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


public class TestActivity6 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void Testcase6() {

        // d. Select the menu item that says “My Account” and click it.
        WebElement myAccount = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/my-account/']"));
        myAccount.click();

        // e. Read the page title and verify that you are on the correct page.
        WebElement myAccountText = driver.findElement(By.cssSelector("h1.uagb-ifb-title"));
        Assert.assertTrue(myAccountText.isDisplayed());

        // f. Find the “Login” button on the page and click it.
        WebElement login = driver.findElement(By.xpath("//a[@href='#login']"));
        login.click();

        // g. Find the username field of the login form and enter the username into that field.
        WebElement userLogin = driver.findElement(By.xpath("//input[@id='user_login']"));
        userLogin.sendKeys("root");

        // h. Find the password field of the login form and enter the password into that field.
        WebElement Password = driver.findElement(By.xpath("//input[@id='user_pass']"));
        Password.sendKeys("pa$$w0rd");

        // i. Find the login button and click it.
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='wp-submit']"));
        submitButton.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ignored){
        }

        // j. Verify that you have logged in.
        WebElement MyAccount = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/']"));
        Assert.assertTrue(MyAccount.isDisplayed());
        Reporter.log(MyAccount.getText());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
