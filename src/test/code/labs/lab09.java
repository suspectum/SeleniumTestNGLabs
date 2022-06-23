package labs;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class lab09 extends TestBase {
    /*
    website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
    Test Scenario:
    * 		Go to the above URL.
    * 		Get the current window’s handle and write to the console window. It must be the first window handle.
    * 		Locate the “Visit W3Schools.com!” link and click it.
    * 		Get all window handles and hold them in a list.
    * 		Write to total window handle number to the console. It must be 2.
    * 		Switch t the second window.
    * 		Get the current window’s handle and write to the console window. It must be a second window handle.
    * 		Check the upper left side logo in the second window.
    * 		Go back (Switch) to the first window.
    * 		Get the current window’s handle and write to the console window. It must be the first window handle.
    * 		Check the See Run Button Text. It must contain “Run >” text.

     */


    @Test
    public void TC1() {
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        currentInfo(driver);

        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//a[.='Visit W3Schools.com!']")).click();

        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowsList = new ArrayList<>();

        int windowSize = allWindows.size();
        System.out.println("windowSize = " + windowSize);

        for (String window : allWindows) {
            driver.switchTo().window(window);
            windowsList.add(window);
            currentInfo(driver);
        }

        driver.switchTo().window(windowsList.get(1));
        currentInfo(driver);

        WebElement logo = driver.findElement(By.xpath("//a[@title='Home']"));
        String logoAttribute = logo.getAttribute("title");
        System.out.println("Title attribute of logo: " + logoAttribute);

        driver.switchTo().window(windowsList.get(0));
        currentInfo(driver);

        WebElement runButton = driver.findElement(By.id("runbtn"));
        Assert.assertEquals(runButton.getText(), "Run ❯");
    }

    public static void currentInfo(WebDriver driver) {
        String currentWindow = driver.getWindowHandle();
        String currentTitle = driver.getTitle();

        System.out.println("=================================");
        System.out.println("currentWindow = " + currentWindow);
        System.out.println("currentTitle = " + currentTitle);

    }
}
