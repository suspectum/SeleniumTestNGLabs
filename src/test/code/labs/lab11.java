package labs;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class lab11 extends TestBase {
    /*
    //Launch the web browser and open the site http://demo.guru99.com/test/delete_customer.php
    //Enter Any Customer id
    //After entering the customer ID, Click on the “Submit” button.
    //Reject/accept the alert.


    Task 2:

    //go to http://the-internet.herokuapp.com/hovers
    //move mouse to third image(you may use move to element method in actions)
    //verify text of image present on the screen
     */


    @Test
    public void TC1() {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("randomID");
        driver.findElement(By.name("submit")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());

        //https://stackoverflow.com/questions/47861236/how-to-handle-multiple-alert-popup-confirmation-in-selenium
        BrowserUtils.resolveAllAlerts(driver, 2, true);

    }
}
