package a_erolhocapracticelesson;

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

public class B01_DropDown {
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
    // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
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
        //driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        // dropdown 3 adım ile handle edilir
        //1- dropdown locate edilir
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        //2-Select objesi olusturulur
        Select select=new Select(ddm);
        //3-option secilir
        select.selectByIndex(1);
        String sectigimOptionIndex=select.getFirstSelectedOption().getText();
        System.out.println("SECTİGİM OPTİON INDEX: " + sectigimOptionIndex);
        Thread.sleep(3000);
        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String sectigimOptionValue=select.getFirstSelectedOption().getText();
        System.out.println("SECTİGİM OPTİON VALUE: " + sectigimOptionValue);
        Thread.sleep(3000);
        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String sectigimOptionVisible=select.getFirstSelectedOption().getText();
        System.out.println("SECTİGİM OPTİON VİSİBLE: " + sectigimOptionVisible);
        // Tüm option'ları yazdırın
        List<WebElement> tumOptionlar=select.getOptions();
        int sayac=1;
        for (WebElement each:tumOptionlar) {
            System.out.println(sayac + ". OPTİON" + each.getText());
            sayac++;
        }
        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected=3;
        int actual=tumOptionlar.size();
        Assert.assertEquals(expected,actual);
    }
}