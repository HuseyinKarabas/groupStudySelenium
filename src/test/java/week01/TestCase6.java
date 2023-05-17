package week01;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class TestCase6 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
    //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverOverElementi= driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOverElementi).perform();
        Thread.sleep(3000);

    //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        Thread.sleep(3000);

    //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(3000);

    //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

    //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        Thread.sleep(3000);

    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.id("click-box")).getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe=driver.findElement(By.tagName("h2"));
        actions.doubleClick();
        Thread.sleep(3000);
    }
}
