package a_erolhocapracticelesson.day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Dropdown extends TestBase {

    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Dropdown menuyu yazdıralım
        //**** 1.YOL
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        //Select select = new Select(dropdown);
        dropdown.forEach(t-> System.out.println(t.getText()));

        //**** 2.YOL
//        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
//        Select select = new Select(dropdown);
//        for (WebElement w : select.getOptions()) {
//            System.out.println(w.getText());
//        }


        //Dropdown menuden baby secelim
        //arama bölümünden milk aratalım
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby"
                , Keys.TAB, "Milk", Keys.ENTER);

    }
}
