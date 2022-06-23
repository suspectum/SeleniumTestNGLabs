package labs;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class lab10 extends TestBase {
    /*
    Prerequisites= Create username and password for guru99
    //navigate to http://demo.guru99.com/V4/
    //Login to Guru99 with username and password
    //Use JavaScript executer to click on login
    //Verify that you login to page
     */


    @Test
    public void TC1() {
        driver.get("http://demo.guru99.com/V4/");
        String userID = "mngr417503";
        String password = "mUdAnyn";
        driver.findElement(By.name("uid")).sendKeys(userID);
        driver.findElement(By.name("password")).sendKeys(password);
        WebElement loginButton = driver.findElement(By.name("btnLogin"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", loginButton);
//        driver.switchTo().alert().accept();
        String expectedTitleWord = "Manager";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleWord));
    }


}

