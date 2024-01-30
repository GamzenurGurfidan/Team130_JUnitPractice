package testsPractice.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class M06_JSAlert extends TestBase {

    /*
        1. Test
        -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        - 1.alert'e tiklayin
        -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        -  OK tusuna basip alert'i kapatin
    */
    /*
        2.Test
        - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        - 2.alert'e tiklayalim
        - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
     */
    /*
        3.Test
        - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        - 3.alert'e tiklayalim
        - Cikan prompt ekranina "Murat" yazdiralim
        - OK tusuna basarak alert'i kapatalim
        - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    */

    @Test
    public void  test03(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        driver.switchTo().alert().sendKeys("I am Gamze");
        driver.switchTo().alert().accept();

        ReusableMethods.bekle(2);

        WebElement resultText = driver.findElement(By.id("result"));

        String expectedText = "Gamze";
        String actualText = resultText.getText();

        Assert.assertTrue(actualText.contains(expectedText));

    }
}
