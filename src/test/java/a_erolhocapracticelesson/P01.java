package a_erolhocapracticelesson;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    /*
        -"amazon.com" adresine gidelim
        -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        -title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        -Ardindan "trendyol.com" adresine gidelim
        -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        -Bi onceki web sayfamiza geri donelim
        -sayfayi yenileyelim
        -Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //-"amazon.com" adresine gidelim
        driver.get("https://amazon.com");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Sayfa Başlığı : "+actualTitle);
        System.out.println("Sayfa Url'i : "+actualUrl);

        //-title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("Spend") && actualUrl.contains("Spend"));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolTitle = driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Sitesi"));

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.quit();// Birden fazla sayfada çalışılmış ise quit() methodu kullanılır
    }

}