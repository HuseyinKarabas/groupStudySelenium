package week01;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass;
public class TestCase04 extends TestBaseClass {
    ///*
    //Test Case 4: Register User with existing email
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and already registered email address
    //7. Click 'signup' button
    //8. Verify error 'Email Address already exist!' is visible
    //*
    @Test
    public void testCase04(){
   driver.get("http://automationexercise.com");

        WebElement sayfaGorunurlugu=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(sayfaGorunurlugu.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("/4. Click on 'Signup / Login' button")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignup.isDisplayed());
        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("huseyin");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("huseyinkarabas@gmail.com");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //8. Verify error 'Email Address already exist!' is visible
        WebElement mailExist= driver.findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(mailExist.isDisplayed());
        System.out.println(mailExist.getText());

    }

}
