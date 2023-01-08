package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {


    @Test
    public void fileDownloadTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        driver.findElement(By.partialLinkText("b10 all test cases, code.docx")).click();
        waitFor(3);  //bunu yapmamiz sart cunku bir sey indirirken belli bir sure geciyor hemen inmiyor
        //hard wait kullanmaliyiz cunku browser ile ilgili bir durum degil; desktop la ilgili, implicity ya da explicity
        // kullanamayiz onlar webelementlerde vb ise yarar

        String homeDirectory = System.getProperty("user.home"); //home yapmadan da yapabiliriz ama o zaman "/users/ASUS/ kismini da basa eklememiz gerekirdi
        String filePath = homeDirectory + "\\Downloads\\b10 all test cases, code.docx";
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);
    }



}
