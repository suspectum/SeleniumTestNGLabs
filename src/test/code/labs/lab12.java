package labs;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class lab12 extends TestBase {
    /*
    //Navigate to "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"
    //Click on the "Try it" button
    //Enter Your name on the Alert Box and Accept alert
    //Verify that your name shown on the page
    //Click on the 'home sign' (it is on the left side of page)
    //Switch to second window tab
    //Click on the "log in" button
    //Enter your credentials
    //Enter the show password button
    //Switch to first tab
     */


    @Test
    public void TC1() {
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("IO");
        alert.accept();
        String actualText = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        String expectedTextWord = "IO";
        Assert.assertTrue(actualText.contains(expectedTextWord));

        driver.switchTo().defaultContent();
        driver.findElement(By.id("tryhome")).click();

        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowsList = new ArrayList<>();

        windowsList.addAll(allWindows);
        driver.switchTo().window(windowsList.get(1));
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("modalusername")).sendKeys("asd@asd.com");
        driver.findElement(By.id("current-password")).sendKeys("asd");
//        driver.findElement(By.xpath("//label[.='Password']/following-sibling::span")).click();
        driver.findElement(By.cssSelector(".PasswordInput_show_pwd_btn__Ncc9S")).click();

        driver.switchTo().window(windowsList.get(0));
    }

}
