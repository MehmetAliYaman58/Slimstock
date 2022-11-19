
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;


public class MainTEST extends BasePage{

    @Test
    public void task1(){
        driver.get("https://www.google.com");
        WebElement googleSearchBarID = driver.findElement(By.className("gLFyf"));
        googleSearchBarID.sendKeys("Slimstock");
        googleSearchBarID.sendKeys(Keys.ENTER);

        WebElement mainPageID = driver.findElement(By.className("LC20lb"));
        String mainPage = mainPageID.getText();

        Assert.assertTrue(mainPage.contains("Slimstock - Envanter Yönetimi Ve Stok Optimizasyonu Programı"));
    }

    @Test
    public void task2()  {
        driver.get("https://www.slimstock.com");
        WebElement allowPüskevit = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        allowPüskevit.click();

        Select deneme = new Select(driver.findElement(By.xpath("//*[@id=\"languageSelector\"]/div/div/form/select")));
        deneme.selectByVisibleText("Turkey");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"languageSelector\"]/div/div/form/button"));
        submitButton.click();

        String turkeyPage = driver.getCurrentUrl();
        Assert.assertEquals(turkeyPage, "https://www.slimstock.com/tr/");

        //************************* PART 2.1 ************************************* //
        WebElement çözümlerimiz = driver.findElement(By.xpath("//*[@id=\"menu-item-154843\"]/a"));

        Actions hoverOnÇözümlerimiz = new Actions(driver);
        hoverOnÇözümlerimiz.moveToElement(çözümlerimiz).perform();

        WebElement titleID = driver.findElement(By.id("menu-item-154890"));
        String title = titleID.getText();
        System.out.println(title);


        WebElement açılanMenü = driver.findElement(By.className("sub-menu"));
        String deneme2 = açılanMenü.getText();
        Assert.assertTrue(deneme2.contains(title));



    }
}
