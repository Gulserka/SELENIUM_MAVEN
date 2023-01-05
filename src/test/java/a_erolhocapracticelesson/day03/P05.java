package a_erolhocapracticelesson.day03;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

    public class P05 extends TestBase {
        @Test
        public void test01() {
            // https://the-internet.herokuapp.com/iframe adresine gidiniz
            driver.get("https://the-internet.herokuapp.com/iframe");

            // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
            WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
            driver.switchTo().frame(iframe);
            WebElement textBox = driver.findElement(By.xpath("//p"));
            textBox.clear();
            textBox.sendKeys("Techproeducation");

            // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
            driver.switchTo().defaultContent();
            WebElement elementalSeleniumLinki = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
            Assert.assertTrue(elementalSeleniumLinki.isDisplayed());

            // Elemental Selenium linkine tıklayın
            elementalSeleniumLinki.click();
            List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
            System.out.println("Açılan pencerelerin handle değerleri : " + windowHandles);
            driver.switchTo().window(windowHandles.get(1));
        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */

            // Açılan sayfada sayfa başlığını yazdırınız
            System.out.println("Elemantal Selenium Sayfa Başlığı : " + driver.getTitle());

            // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
            WebElement sourceLabsLinki = driver.findElement(By.xpath("//*[text()='Sauce Labs']"));
            Assert.assertTrue(sourceLabsLinki.isDisplayed());

            // Source labs linkine tıklayın
            System.out.println("--------------------------------------------------");
            sourceLabsLinki.click();
            List<String> windowHandles2 = new ArrayList<>(driver.getWindowHandles());
            System.out.println(windowHandles2);
            driver.switchTo().window(windowHandles2.get(2));

            // Açılan sayfada sayfa başlığını yazdırınız
            System.out.println("Source Labs Sayfa başlığı : " + driver.getTitle());

            // ilk sekmeye geri dönelim ve url'ini yazdıralım
            driver.switchTo().window(windowHandles2.get(0));
            System.out.println("Sayfa url'i : " + driver.getCurrentUrl());

            // ilk sekmeyi kapatalım
            driver.close();
            driver.switchTo().window(windowHandles2.get(2));
            System.out.println(driver.getCurrentUrl());
        }


    }
