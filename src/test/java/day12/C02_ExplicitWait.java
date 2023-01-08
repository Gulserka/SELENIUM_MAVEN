package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ExplicitWait extends TestBase {

    //impicitly wait : Sayfa üzerindeki tüm öğeler için zaman aşımı
    //explicitly wait  : belirli elementler için zaman aşımı
    // Note: implicitlyWait Sayfa daki webelementlerin yüklenmesi için bekliyor ama içerde bir buttona basınca loading yani bekleme yaparken çalışmıyor


    @Test
    public void explicitWaitTest(){

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));

        //Hello World! Yazının sitede oldugunu test et
        Assert.assertEquals("Hello World!",helloWorldElement.getText());




    }
}
