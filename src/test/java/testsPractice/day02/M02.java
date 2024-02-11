package testsPractice.day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

public class M02 extends TestBase {

        // https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin
        // Ülke menüsünü locate edin
        // Türkiye Seçeneğini seçin
        // Go to website butonuna tıklayın

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/");

        WebElement countryDDM = driver.findElement(By.id("icp-dropdown"));
        Select select = new Select(countryDDM);

        select.selectByIndex(19);
        System.out.println(select.getFirstSelectedOption().getText());

        ReusableMethods.bekle(2);

        driver.findElement(By.className("a-button-input")).click();

        ReusableMethods.bekle(2);

        driver.quit();

    }

}
