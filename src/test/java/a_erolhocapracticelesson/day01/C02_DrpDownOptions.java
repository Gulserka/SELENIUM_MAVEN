package a_erolhocapracticelesson.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DrpDownOptions {
    // ...Exercise 2...


    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void test02() {

        // ...Exercise 2...


        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        //dropdown 3 adımda handle edilir
        //1- locate edilmeli
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-Select objesi olusturulmalı
        Select select=new Select(ddm);

        //3-opsiyon secilir
        select.selectByVisibleText("Baby");


        // sectiginiz option'i yazdirin
        String sectigimOption=select.getFirstSelectedOption().getText();  //getFirstSelectedOption() webElement dondurdugu icin gettext ile Stringe cevirdik
        System.out.println("SECTİGİ MOPTİON : " + sectigimOption);



        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

        List<WebElement> tumOptionlar=select.getOptions();

        int actuelOptionSayısı=tumOptionlar.size();
        int expectedOptionSayısı=28;


        Assert.assertEquals(expectedOptionSayısı,actuelOptionSayısı);





    }
}
