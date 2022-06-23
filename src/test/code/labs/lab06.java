package labs;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class lab06 extends TestBase {
    /*
    //go to http://demo.guru99.com/test/newtours/register.php
    // click on country dropdown and select Barbados with Select Method
    //Use 3 different Select Method (visible text,index,value)
    //and switch to another countries as you wish
    */


    @Test
    public void TC1() {
        driver.get("http://demo.guru99.com/test/newtours/register.php");
        WebElement dropdownBox = driver.findElement(By.name("country"));
        Select dropdown = new Select(dropdownBox);
        dropdown.selectByVisibleText("CANADA");
        BrowserUtils.wait(1);
        dropdown.selectByValue("ZIMBABWE");
        BrowserUtils.wait(1);
        dropdown.selectByIndex(33);
    }
}
