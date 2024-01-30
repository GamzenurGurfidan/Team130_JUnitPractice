package testsPractice.day02;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.security.Key;

public class M03_FakerClass extends TestBase {

    // https://www.automationexercises.com adresine
    // faker class kullanarak üye formunu doldurup
    // Başarıyla üye olunduğunu doğrulayınız

    @Test
    public void fakerClass(){
        driver.get("https://www.automationexercise.com/");
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[2]"));

        Faker faker = new Faker();

        String isim = faker.name().fullName();
        String mail = faker.internet().emailAddress();

        Actions actions = new Actions(driver);

        actions.click(name)
                .sendKeys(isim)
                .sendKeys(Keys.TAB)
                .sendKeys(mail)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(2);

        driver.findElement(By.id("id_gender2")).click();

        WebElement passwordBox = driver.findElement(By.id("password"));

        actions.click(passwordBox)
                .sendKeys(faker.internet().password(3,8))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(2);

        WebElement hesapOlusturuldu = driver.findElement(By.xpath("//*[@class='title text-center']"));

        String expectedIcerik ="ACCOUNT CREATED!";
        String actualIcerik = hesapOlusturuldu.getText();

        Assert.assertEquals(expectedIcerik,actualIcerik);

    }
}
