package day10;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class C01_Actions1 extends TestBase {
    @Test
    public void rightClick(){
//    https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
//        1. ACTIONS OBJESI OLUSTUR
        Actions actions = new Actions(driver);
//       2. ELEMENT I LOCATE ADELIM
        WebElement kutu = driver.findElement(By.id("hot-spot"));
//    Kutuya sag tıklayın
//        TUM ACTIONS LAR actions OBJESIYLE BASLAR permorm() ILE BITER
        actions.contextClick(kutu).perform();
//    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
//        Object olusturmak wait gerekdiren durumlarda makul
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
//    Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}