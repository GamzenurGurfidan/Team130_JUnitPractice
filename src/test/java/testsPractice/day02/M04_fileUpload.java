package testsPractice.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class M04_fileUpload extends TestBase {

    /*

        https://the-internet.herokuapp.com/upload adresine giderek
        bir dosyayı siteye upload edip. Upload edildiğini doğrulayınız

     */

    @Test
    public void fileUploadTesti(){

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement upload = driver.findElement(By.id("file-upload"));

        String dosyaYolu = "C:\\Users\\Gamzenur\\IdeaProjects\\T130_JUnitPractice\\src\\test\\java\\testsPractice\\day02\\img.png";

        upload.sendKeys(dosyaYolu);

        driver.findElement(By.id("file-submit")).click();

        WebElement uploaded = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));

        Assert.assertTrue(uploaded.isDisplayed());

        ReusableMethods.bekle(1);

    }
}
