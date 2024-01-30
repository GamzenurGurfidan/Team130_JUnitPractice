package testsPractice.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class M05_Iframe extends TestBase {

    // https://the-internet.herokuapp.com/iframe adresindeki form içindeki yaziyi silip
    // yerine baska bir metin yazalim

    @Test
    public void iframeTest(){

        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement ifameText  = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(ifameText.isDisplayed());
        System.out.println(ifameText.getText());

        WebElement iframeElementi = driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame("mce_0_ifr");

        WebElement yaziElementi = driver.findElement(By.id("tinymce"));
        System.out.println(yaziElementi.getText());

        yaziElementi.clear();
        yaziElementi.sendKeys("Yeni Metin Efendim!");

        ReusableMethods.bekle(2);

        driver.switchTo().defaultContent();



    }

}
