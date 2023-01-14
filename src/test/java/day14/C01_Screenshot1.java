package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {
/*
Selenium tun ekran goruntusu nasil alinir?
    -tum ekran goruntusu seleniumdan gelen getScreenshotAs metotu ile alinir.
    -getScreenshotAs metotu seleniumdaki TakesScreenshot api indan gelir
 */

    @Test
    public void fullPageScreenshotTest() throws IOException {
//        Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

        waitFor(1);

//        1. Ekran goruntusunu getScreenshotAs metotu ile alip File olarak olusturalim
        File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//        2. Almis oldugum ekran goruntusunu belirledigim bir PATH e kaydet.dir= directory=dosya
//        NOTE: kayit ismini dinamik yapmak icin date objesi kullandim
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
//        String path = System.getProperty("user.dir")+"\\test-output\\EkranGoruntuleri\\image.png";//CALISMIYORSA WINDOW ICIN
        File hedef = new File(path);

//        3. Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(goruntu,hedef);

//        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
//                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path

//        -“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+Keys.ENTER);

        waitFor(3);
//        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));

//       Reusable metod yardimiyla ekran goruntusunu alalim
        takeScreenShotOfPage();


    }


}