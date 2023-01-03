package a_erolhocapracticelesson.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P01 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();
        System.out.println(driver.switchTo().alert().getText()); // Alert üzerindeki yazıyı konsola yazdırdık
        driver.switchTo().alert().accept(); // Alertte tamam'a bastık


        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        //    cancel Alert  (Press a Button !)
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello TechProEducation How are you today"
        System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());

        //    aseertion these message
        Assert.assertEquals("Hello TechProEducation How are you today", driver.findElement(By.xpath("//*[@id='demo1']")).getText());


    }

}

