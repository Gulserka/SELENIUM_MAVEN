package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TimeOutException explicit wait kullandimda ve locator bulunamadiginda alirim
     */
    @Test
    public void timeOutExceptionTest(){
        driver.get("https://www.techproeducation.com");
//        Explit wait icin olusturdugumuz methodlardan birini kullanalim
//        Parametre 1: beklemek istedigim element, Parametre 2: Max sure
//        waitForVisibility(By.xpath("//input[@type='searchh']"),25)//org.openqa.selenium.TimeoutException:
//                .sendKeys("QA"+ Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:


    }
}