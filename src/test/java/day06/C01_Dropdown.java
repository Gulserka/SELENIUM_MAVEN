package day06;

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


public class C01_Dropdown {

    WebDriver driver;

    //    Eger test sinifinda birden fazla method olusturulmussa, @Before kullanir
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest(){


//        1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
//        2. Select objesi olustur
        Select yearDropdown = new Select(year);
//        3. Select object i kullaarak 3 farkli sekilde secim yapabilirim
        yearDropdown.selectByIndex(22);//SECENEK SIRASI 0 DAN BASLAR. 2000 yili 23. sirada
//        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10


//      Ay Secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");//option in value degeri ile secim yapilabilir. January seceneinin value si 0

//        Gun secimi selectByVisibleTest
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");//CASE SENSITIVE -

    }

    @Test
    public void printAllTest(){

//        Tum eyalet isimlerini consola yazdiralim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();
//       for (WebElement eachState : stateList){
//           System.out.println(eachState.getText());}
        stateList.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptionsTest(){
//       State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);

//        WebElement varsayilanElement = stateDropdown.getFirstSelectedOption();
//        String varsayilanElementText = varsayilanElement.getText();

        String varsayilanText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",varsayilanText);
    }

    @After
    public void tearDown(){
        driver.close();
    }






    /*
    1. What is dropdown? Dropdown nedir?
    Dropdown liste olusturmak icin kullanilir.
    2. How to handle dropdown elements? Dropdown nasil automate edilir?
    -dropdown i locate ederim
    -select objesi olustururum
    -select objesi ile istedigim secenegi secerim
    NOT: select objesi olusturma nedenim, dropdownlarin Select classi ile olusturulmasi
    3. Tum dropdown seceneklerini nasil print ederiz?
    - tum dropdown elementlerini getOptions() methodu ile listeye koyariz
    - sonra secenekleri loop ile yazdirabilirz
    4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
    Ornek: Gun olarak 10 i secdik ama ya secilmediyse?
    getFirstSelectedOption() secili olan secenegi return eder
     */





}