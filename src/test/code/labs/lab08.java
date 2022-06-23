package labs;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class lab08 extends TestBase {
    /*
    1)Launch the web browser and open the site http://demo.guru99.com/test/delete_customer.php
    Step 2) Enter Any Customer id.
    Step 3) After entering the customer ID, Click on the “Submit” button.
    Step 4) Reject/accept the alert.
     */


    @Test
    public void TC1() {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("customer1");
        driver.findElement(By.name("submit")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
//        alert.accept();
//        alert.accept();

        //https://stackoverflow.com/questions/47861236/how-to-handle-multiple-alert-popup-confirmation-in-selenium
        BrowserUtils.resolveAllAlerts(driver, 2, true);
    }
}
