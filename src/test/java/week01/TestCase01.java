package week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class TestCase01 {
    /*
    Test Case 1: Verify the Login Functionality
    1- Launch the website https://automationexercise.com/
    2- Click on the "Login" button on the top right corner of the page
    3- Enter a valid email address and password in the respective fields
    4- Click on the "Sign in" button
    5- Verify that the user is logged in by checking if the "My account" page is displayed
    6- Logout of the website
     */
    WebDriver driver;
    public void getDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        getDriver();
      //1- Launch the website https://automationexercise.com/
        driver.get("https://automationexercise.com/");
      //2- Click on the "Login" button on the top right corner of the page
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        Thread.sleep(3000);

      //3- Enter a valid email address and password in the respective fields
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("huseyinkarabas@gmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
        Thread.sleep(3000);

      //4- Click on the "Sign in" button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

      //5- Verify that the user is logged in by checking if the "My account" page is displayed
        WebElement myAccount=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"));

        Assert.assertTrue(myAccount.isDisplayed());
        Thread.sleep(3000);
      //6- Logout of the website
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();
        Thread.sleep(3000);
        driver.close();

    }
}
