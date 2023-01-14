package a_erolhocapracticelesson.burakhoca;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
public class C01_WindowHandle extends TestBase {
    // 1- https://www.amazon.com sayfasına gidin
    // 2- nutella icin arama yapın
    // 3- yeni bir tab'da ilk urunun resmine tıklayınız
    // 4- yeni tab'da acilan urunun basligini yazdirin
    // 5- ilk sayfaya gecip url'i yazdırın
    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String sayfa1Handle = driver.getWindowHandle();
        // 2- nutella icin arama yapın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella" + Keys.ENTER);
        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella" + Keys.ENTER);
        WebElement ilkurun = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkurun.click();
        // 4- yeni tab'da acilan urunun basligini yazdirin
        WebElement baslik = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String baslikStr = baslik.getText();
        System.out.println("BASLİK: " + baslikStr);
        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(sayfa1Handle);
        String ilkSayfaUrl = driver.getCurrentUrl();
        System.out.println("İLKSAYFA URL : " + ilkSayfaUrl);
    }
}
