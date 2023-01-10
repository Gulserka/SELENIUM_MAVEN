package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    //impicitly wait : Sayfa üzerindeki tüm öğeler için zaman aşımı
    //explicitly wait  : belirli elementler için zaman aşımı
    // Note: implicitlyWait Sayfa daki webelementlerin yüklenmesi için bekliyor ama içerde bir buttona basınca loading yani bekleme yaparken çalışmıyor



    @Test
    public void explicitWaitTest(){
         /*
      https://the-internet.herokuapp.com/dynamic_loading/1
      Start buttonuna tıkla
      Hello World! Yazının sitede oldugunu test et
       */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!",helloWorldElement.getText());
//        IMPLICIT WAIT ILE TEST CASE CALISMADI.
//        COZUM EXPLICIT WAITDE

//        1. WebDriverWait objesini olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//        2. wait objesini kullanarak bekleme problemini cozmeye calis
        WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);






    }
}
