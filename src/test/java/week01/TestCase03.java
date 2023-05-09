package week01;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class TestCase03 {
    /*
     Test Case 3: Logout User
     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click on 'Signup / Login' button
     5. Verify 'Login to your account' is visible
     6. Enter correct email address and password
     7. Click 'login' button
     8. Verify that 'Logged in as username' is visible
     9. Click 'Logout' button
     10. Verify that user is navigated to login page
     */
    WebDriver driver;
    public void getDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test03(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com'");

        //3. Verify that home page is visible successfully
        WebElement anasayfa=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
       String actualTitle= driver.getTitle();
       String expectedTitle="Aıtomation Exercise";
        Assert.assertEquals(actualTitle,expectedTitle,"Test FAILED");
        Assert.assertTrue(anasayfa.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@type='email'])[1]")).click();
        driver.findElement(By.xpath("//*[@type='password']")).click();

        WebElement myAccount=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"));
        Assert.assertTrue(myAccount.isDisplayed());

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Logout' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();

        //10. Verify that user is navigated to login page
    }
}
