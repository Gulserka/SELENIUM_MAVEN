package day04_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Tekrar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //-Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");
        //-Arama kutusunu locate ediniz
        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder=""
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search" spellcheck="false">
         */
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //-Arama kutusunun tagName'inin input olduğunu test ediniz
        String actualTagname = aramaKutusu.getTagName();
        String expectedTagname = "input";
        if (actualTagname.equals(expectedTagname)){
            System.out.println("Tagname Testi PASSED : " +actualTagname);
        }else System.out.println("Tagname Testi FAILED" +actualTagname);

        //-Arama kutusunun name atributu'nun değerinin field-keywords olduğunu test ediniz
        String actualAttributeName = aramaKutusu.getAttribute("name");
        String expectedAttributeName = "field-keywords";
        if (actualAttributeName.equals(expectedAttributeName)){
            System.out.println("Atribute TESTİ PASSED");
        }else System.out.println("Atribute TESTİ FAILED");

        //-Sayfayı kapatınız
        driver.close();
    }
}