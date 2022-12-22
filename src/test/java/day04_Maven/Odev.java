package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev {
    //C01_TekrarTesti isimli bir class olusturun

    // 3- cookies uyarisini kabul ederek kapatin




    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Sayfa basligi Google ifadesi iceriyor.");
        }else {
            System.out.println("Sayfa basligi Google ifadesi icermiyor.");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("nutella", Keys.ENTER);


        //6- Bulunan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@id='result-stats']"));



        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin



        //8- Sayfayi kapatin
        //driver.close();

    }











}
