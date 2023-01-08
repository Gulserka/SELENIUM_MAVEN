package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    @Test
    public void fileUploadTest(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

   /*
        chooseFileButton una yuklemek istedigim dosyanin path ini gondererek dosyayi sectim.
         */
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\logo.jpeg";
        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(3);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String uploadedYazisi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",uploadedYazisi);
        waitFor(5);








    }









}
