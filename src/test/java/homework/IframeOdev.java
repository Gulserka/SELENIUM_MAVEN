package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class IframeOdev {

    //Bir class olusturun: IframeOdev
    //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
    //sayfadaki toplam iframe sayısını bulunuz.
    //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
    //Paragrafdaki yaziyi silelim
    //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
    //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void test01(){
        int list = driver.findElements(By.tagName("iframe")).size();
       // System.out.println("iframe sayisi = " + list.size());



        String metin = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(metin.contains("Editor"));

        driver.switchTo().frame(0);
        String icMetin = driver.findElement(By.xpath("//p[text()='Your content goes here.']")).getText();

        driver.findElement(By.xpath("//p[text()='Your content goes here.']")).clear();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("iframe in icindeyim");

        driver.switchTo().defaultContent();
        String altYazi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertTrue(altYazi.contains("Elemental Selenium"));

    }









}
