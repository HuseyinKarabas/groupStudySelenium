package week01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase7 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

    //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
    //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.SPACE).sendKeys(Keys.SPACE).perform();
        Thread.sleep(3000);
    //4- videoyu izlemek icin Play tusuna basin
        WebElement youtubeIframe= driver.findElement(By.xpath("//iframe[@height='315']"));
        driver.switchTo().frame(youtubeIframe);
        WebElement youtubePlay= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        youtubePlay.click();
        Thread.sleep(3000);

    //5- videoyu calistirdiginizi test edin
        WebElement youtubeGorunur= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeGorunur.isDisplayed());
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }
}
