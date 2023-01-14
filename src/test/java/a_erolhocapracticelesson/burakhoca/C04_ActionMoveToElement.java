package a_erolhocapracticelesson.burakhoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
public class C04_ActionMoveToElement extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
    @Test
    public void test04() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement dilMenu=driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(dilMenu).perform();
        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm=driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        //Drop down opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
        //herhangi bir yere clic yapıp drop down opsiyon listesinin toparlanmasını sagladık
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
    }
}
