package week01;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
public class TestCase05 extends TestBase {
    @Test
    public void testCase05() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement visible= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(visible.isDisplayed());
        Thread.sleep(3000);

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//i[@style='font-size: 16px;']")).click();
        Thread.sleep(3000);

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement page=driver.findElement(By.xpath("//img[@id='sale_image']"));
        Assert.assertTrue(page.isDisplayed());
        Thread.sleep(3000);

        //6. The products list is visible
        WebElement productLists=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productLists.isDisplayed());
        Thread.sleep(3000);

        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//ul[@class='nav nav-pills nav-justified'])[1]")).click();
        Thread.sleep(3000);
        //8. User is landed to product detail page
        WebElement productDetail=driver.findElement(By.xpath("//h2[text()='Blue Top']"));
        Assert.assertTrue(productDetail.isDisplayed());
        Thread.sleep(3000);

        //9. Verify that  detail is visible: product name, category, price, availability, condition, brand
        WebElement category=driver.findElement(By.xpath("//p[text()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price=driver.findElement(By.xpath("//span[text()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        Thread.sleep(3000);

        WebElement brand=driver.findElement(By.xpath("//*[text()=' Polo']"));
        Assert.assertTrue(brand.isDisplayed());
        Thread.sleep(3000);



    }


}
