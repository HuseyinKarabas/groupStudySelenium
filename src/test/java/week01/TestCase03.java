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

    public void mahserin4Atlisi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test() throws InterruptedException {

        // 1. Launch browser
        mahserin4Atlisi();

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement anaSayfa = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        System.out.println(anaSayfa.getText());

        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        System.out.println(driver.getTitle());

        Assert.assertEquals(expectedTitle, actualTitle,"test FAILED");

        Assert.assertTrue(anaSayfa.isDisplayed());

        // 4. Click on 'Signup / Login' button
        WebElement signupLogin = driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        signupLogin.click();

        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("huseyinkarabas@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        Thread.sleep(3000);

        // 5. Verify 'Login to your account' is visible
        WebElement sayfaGorunurlugu = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        System.out.println(sayfaGorunurlugu.getText());

        Assert.assertTrue(sayfaGorunurlugu.isDisplayed());

        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();
        Thread.sleep(3000);

        WebElement cikis = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        System.out.println(cikis.getText());

        Assert.assertTrue(cikis.isDisplayed());

        driver.close();
    }
}
