package a_erolhocapracticelesson.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P07_BuyukKucukHarf extends TestBase {
    @Test
    public void name() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        //Büyük küçük harf olucak şekilde HeLlO yazdıralım
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);


    }
}
