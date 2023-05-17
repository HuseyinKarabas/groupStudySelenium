package week01;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase09 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='tablestest']")).click();

        //web table tum body i yazidr
        WebElement tumBodyElementi=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBodyElementi.getText());
        Thread.sleep(2000);

        //5. satirda 1.datayi yazdirin
        WebElement besinciSatirBirinciData=driver.findElement(By.xpath("//tbody/tr[5]/td[1]"));
        System.out.println(besinciSatirBirinciData.getText());
        Thread.sleep(2000);

        //5.satiri yaazdirin
        System.out.println("==========");
        WebElement besinciSatir=driver.findElement(By.xpath("//tbody/tr[5]"));
        System.out.println(besinciSatir.getText());
        Thread.sleep(2000);

        //Web Table satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriList=driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi=5;
        int actualSatirSayisi=satirElementleriList.size();
        Thread.sleep(2000);

        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //tum satirlari yazdirin
        for (WebElement eachSatir:satirElementleriList) {
            System.out.println(eachSatir.getText());
            Thread.sleep(2000);
        }
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='tablestest']")).click();

        //Web Table'daki sütun sayisinin 2 old test edin?
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//tbody/tr[2]/td"));
        int expectedSutunSayisi=2;
        int actualSutunSayisi=sutunSayisi.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);
    }

}

