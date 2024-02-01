package testsPractice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M03_Test01 {

    /*    Exercise-1:

            BeforeClass ile driver'i oluşturun ve class icinde static yapin
            Maximize edin ve 10 sn bekletin
            her biri https://www.gooqle.com adresine gidin
            1-arama kutusuna "12 Angry Men" yazip, cikan sonuc sayisini yazdirin
            2-arama kutusuna "Vizontele" yazip, cikan sonuc sayisini yazdirin
            3-arama kutusuna "Saving Private Ryan" yazip, cikan sonuc sayisini yazdirin
            AfterClass ile kapatin.
     */
    static WebDriver driver;
    String strSonucYazisi;
    WebElement searchBox;
    String movie;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Before
    public void before(){
        driver.get("https://www.google.com/");
        searchBox = driver.findElement(By.className("gLFyf"));
    }
    @After
    public void sonucYazisi(){
        System.out.println("Test sonuc yazisi: " + strSonucYazisi);
        System.out.println(movie + " filminin sonuc sayisi " + driver.findElement(By.id("result-stats")).getText() + "\n");
    }


    @Test
    public void test01(){
        // 1-arama kutusuna "12 Angry Men" yazip, cikan sonuc sayisini yazdirin

        searchBox.sendKeys("12 Angry Men" + Keys.ENTER);

        movie = "12 Angry Men";

        WebElement ofkeliAdam =
                driver.findElement(By.xpath("//*[@class='PZPZlf ssJ7i xgAzOe']"));
        strSonucYazisi = ofkeliAdam.getText();

    }
    @Test
    public void test02(){
        // 2-arama kutusuna "Vizontele" yazip, cikan sonuc sayisini yazdirin

        searchBox.sendKeys("Vizontele" + Keys.ENTER);

        movie = "Vizontele";

        WebElement vizontele =
                driver.findElement(By.xpath("//*[@class='PZPZlf ssJ7i B5dxMb']"));
        strSonucYazisi = vizontele.getText();

    }
    @Test
    public void test03(){
        // 3-arama kutusuna "Saving Private Ryan" yazip, cikan sonuc sayisini yazdirin
        searchBox.sendKeys("Saving Private Ryan" + Keys.ENTER);

        movie = "Saving Private Ryan";

        WebElement erRayn =
                driver.findElement(By.xpath("//*[@class='PZPZlf ssJ7i xgAzOe']"));
        strSonucYazisi = erRayn.getText();

    }

}
