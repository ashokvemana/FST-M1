//7. Count the number of courses
       // Goal: Navigate to the “All Courses” page and count the number of courses.
       // a. Open a browser.
       // b. Navigate to ‘https://alchemy.hguy.co/lms’.
       // c. Find the navigation bar.
       // d. Select the menu item that says “All Courses” and click it.
       // e. Find all the courses on the page.
       // f. Print the number of courses on the page.


package Project_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActivity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void Testcase7() {

        // d. Select the menu item that says “All Courses” and click it.
        WebElement Allcourses = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/lms/all-courses/']"));
        Allcourses.click();

        // e. Find all the courses on the page.
        int Count = driver.findElements(By.xpath("//p[@class='ld_course_grid_button']")).size();
        Assert.assertEquals(Count,3);

        // f. Print the number of courses on the page.
        String courseCount = String.valueOf(Count);
        System.out.println("Number of Courses available  :" + courseCount);
    }

    @AfterMethod
    public void afterMethod() {

        //Close the browser
        driver.quit();
    }
}
