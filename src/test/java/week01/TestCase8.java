package week01;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import java.util.List;
import java.util.Set;
public class TestCase8 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //1-Navigate to http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");
        String ilkWHDDegeri= driver.getWindowHandle();
        System.out.println(ilkWHDDegeri);
        Thread.sleep(2000);

        //2-Find the number of iframes on the page.
        List<WebElement> tagIframe=driver.findElements(By.tagName("iframe"));
        System.out.println(tagIframe.size());

        //3-Click on the first iframe button that contains a Youtube video.
        WebElement iframGiris= driver.findElement(By.xpath("//iframe[@height='315']"));
        driver.switchTo().frame(iframGiris);
        Thread.sleep(2000);
        WebElement playYoutube= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playYoutube.click();
        Thread.sleep(2000);

        //4-Exit from the first iframe and return to the main page.
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        //5-Click on the second iframe button that has the text "JMeter Made Easy"//and navigate to the page https://www.guru99.com/live-selenium-project.html.
        WebElement ikinciIframeElementi= driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(ikinciIframeElementi);

        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        Set<String> toplamWHD=driver.getWindowHandles();
        String ikinciWHD="";
        for (String eachWHD:toplamWHD) {
            if(!eachWHD.equals(ilkWHDDegeri)){
                ikinciWHD=eachWHD;
            }
        }
        System.out.println(ikinciWHD);
        driver.switchTo().window(ikinciWHD);
        System.out.println(toplamWHD);
        Thread.sleep(2000);

        WebElement selenium= driver.findElement(By.xpath("//h1[text()='Selenium Live Project: FREE Real Time Project for Practice']"));
        Assert.assertTrue(selenium.isDisplayed());
        Thread.sleep(2000);
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getWindowHandle());


    }
}
