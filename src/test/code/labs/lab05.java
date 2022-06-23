package labs;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class lab05 extends TestBase {
    /*
    //Go to Amazon
    //enter Desk in search box
    //Then search for desks
    (Use this task with TestNG framework)
     */


    @Test
    public void TC1() {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Desk" + Keys.ENTER);

        String expectedTitleWord = "Desk";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleWord));

    }
}
