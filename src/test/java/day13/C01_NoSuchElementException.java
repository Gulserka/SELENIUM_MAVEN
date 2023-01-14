package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.security.Key;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementTest(){
        /*
         */
        driver.get("https://www.techproeducation.com");
        driver.
                findElement(By.xpath("//input[@type='searchh']")).//org.openqa.selenium.NoSuchElementException:
                sendKeys("QA"+ Keys.ENTER);

    }

}