package testsPractice.day02;

import org.junit.Test;
import utilities.TestBase;

public class M02 extends TestBase {

        // https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin
        // Ülke menüsünü locate edin
        // Türkiye Seçeneğini seçin
        // Go to website butonuna tıklayın

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/");

    }

}
