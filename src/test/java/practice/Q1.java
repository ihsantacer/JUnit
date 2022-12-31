package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*
    1- C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4- Sayfa basliginin “Google” ifadesi icerdigini test edin 5- Arama cubuguna “Nutella” yazip aratin
6- Bulunan sonuc sayisini yazdirin
7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin 8- Sayfayi kapatin
     */
     static  WebDriver driver;
    @BeforeClass
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass

    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.google.com/");

        Thread.sleep(3000);
    }

    @Test
    public void test2(){
        String expected="Google";
        String actual=driver.getTitle();

        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void test3(){
        WebElement aramacubugu=driver.findElement(By.className("gLFyf"));
        aramacubugu.sendKeys("nutella", Keys.ENTER);

    }

    @Test
    public void test4(){



        WebElement sonucsayı=driver.findElement(By.id("result-stats"));

        String sonucsayisistr=sonucsayı.getText();
        System.out.println(sonucsayisistr);
        String [] sonucarr=sonucsayisistr.split(" ");
        String sonadetsonuc=sonucarr[1];
        String sonadet1=sonadetsonuc.replaceAll("\\D", "");
        int adet=Integer.parseInt(sonadet1);
        int expected=100000000;

        Assert.assertTrue(adet>expected);



    }

}
