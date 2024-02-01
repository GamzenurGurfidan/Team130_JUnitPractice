package testsPractice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M04_Test02 {
    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Çıkıyorsa Kullanici cookies i kabul eder
    // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alin
    // Karsilastirilacak olan para biriminin 28 den kucuk oldugu test edilir

    static WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.className("gLFyf"));
        searchBox.sendKeys("dolar" + Keys.ENTER);

        WebElement turkLirasi = driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));

        String resultMoney = turkLirasi.getText().replace(",",".");
        double resultDouble = Double.parseDouble(resultMoney);

        Assert.assertFalse(resultDouble < 30);

        if (resultDouble >30 ){
            System.out.println("biri bunu durdursun");
        } else System.out.println("30dqan küçük");


    }

}
