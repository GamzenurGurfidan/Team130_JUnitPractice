package testsPractice.day02;

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
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class M01_DropdownMenu {

    //DropDownMenu Kullanımı
    /*
         // https://the-internet.herokuapp.com/dropdown adresine gidin.
         // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
         // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
         // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
         // 4.Tüm dropdown değerleri(value) yazdırın
         // 5.Dropdown'un boyutunun 3 olduğunu test edin
    */

    static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void dropDownMenu() {

        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownMenu = driver.findElement(By.id("dropdown"));
        Select option1 = new Select(dropdownMenu);
        option1.selectByIndex(1);

        System.out.println(option1.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);

        option1.selectByValue("2");

        System.out.println(option1.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);

        option1.selectByVisibleText("Option 1");

        System.out.println(option1.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);

        List<WebElement> tumOpsiyonlar = option1.getOptions();

        System.out.println(ReusableMethods.strListeCevir(tumOpsiyonlar));

        Assert.assertEquals(tumOpsiyonlar.size(),3);

    }
}
