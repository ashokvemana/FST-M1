//9. Complete a simple lesson
        //Goal: Navigate to a particular lesson and complete it.
        //a. Open a browser.
        //b. Navigate to ‘https://alchemy.hguy.co/lms’.
        //c. Find the navigation bar.
        //d. Select the menu item that says “All Courses” and click it.
        //e. Select any course and open it.
        //f. Click on a lesson in the course. Verify the title of the course.
        //g. Click the Mark Complete button on the page (if available).
        //h. Close the browser.

package Project_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActivity9 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void Testcase9() {

        WebElement myAccount = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/my-account/']"));
        myAccount.click();

        WebElement myAccountText = driver.findElement(By.cssSelector("h1.uagb-ifb-title"));
        Assert.assertTrue(myAccountText.isDisplayed());

        WebElement login = driver.findElement(By.xpath("//a[@href='#login']"));
        login.click();

        WebElement userLogin = driver.findElement(By.xpath("//input[@id='user_login']"));
        userLogin.sendKeys("root");

        WebElement Password = driver.findElement(By.xpath("//input[@id='user_pass']"));
        Password.sendKeys("pa$$w0rd");

        WebElement submitButton = driver.findElement(By.xpath("//input[@id='wp-submit']"));
        submitButton.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ignored){
        }

        WebElement MyAccount = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/']"));
        Assert.assertTrue(MyAccount.isDisplayed());

        WebElement Allcourses = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/all-courses/']"));
        Allcourses.click();

        WebElement SocialMediaButton = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/courses/social-media-marketing/']"));

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ignored){
        }

        WebElement SeeMore = driver.findElement(By.cssSelector("#post-69 > div:nth-child(3) > p:nth-child(3) > a:nth-child(1)"));
        SeeMore.click();

        WebElement DevelopingStrategy = driver.findElement(By.cssSelector("div.ld-item-list-item:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
        DevelopingStrategy.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ignored){
        }

        WebElement DevelopingStrategyStatus = driver.findElement(By.cssSelector(".ld-table-list-lesson-details"));

        Assert.assertTrue(DevelopingStrategyStatus.getText().contains("100% COMPLETE"));
        System.out.println(DevelopingStrategyStatus.getText());

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}