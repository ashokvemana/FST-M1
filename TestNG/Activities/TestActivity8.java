//8. Contact the admin
        //Goal: Navigate to the “Contact Us” page and complete the form.
        //a. Open a browser.
        //b. Navigate to ‘https://alchemy.hguy.co/lms’.
        //c. Find the navigation bar
        //d. Select the menu item that says “Contact” and click it.
        //e. Find the contact form fields (Full Name, email, etc.)
        //f. Fill in the information and leave a message.
        //g. Click submit.
        //h. Read and print the message displayed after submission.
        //i. Close the browser.

package Project_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActivity8{
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        //Open browser
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void Testcase8() {

        WebElement Contact = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/contact/']"));
        Contact.click();

        WebElement FullName = driver.findElement(By.xpath("//*[@id='wpforms-8-field_0']"));
        FullName.sendKeys("Ashok Vemana");

        WebElement EMail = driver.findElement(By.xpath("//*[@id='wpforms-8-field_1']"));
        EMail.sendKeys("ask@testmail.com");

        WebElement Subject = driver.findElement(By.xpath("//*[@id='wpforms-8-field_3']"));
        Subject.sendKeys("Test Subject - Ashok Vemana");

        WebElement Comment = driver.findElement(By.xpath("//*[@id='wpforms-8-field_2']"));
        Comment.sendKeys("Test - LMS Project");

        WebElement Submit = driver.findElement(By.xpath("//*[@id='wpforms-submit-8']"));
        Submit.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ignored){
        }

        WebElement Message= driver.findElement(By.xpath("//h2[@class='uagb-heading-text']"));
        Assert.assertEquals(Message.getText(),"Send us a message");
        System.out.println("Number of Courses available  :" + Message);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
