package labs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class lab04 {
/*
//1. Open Chrome browser
//2. Go to https://demo.guru99.com/test/radio.html
//3. Verify all checkboxes are not selected (you can use findelements to store in list and use for loop to validate)
//4. Click to checkbox3
//5. Verify checkbox3 is selected
*/

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.guru99.com/test/radio.html");

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

//        driver.findElement(By.xpath("//input[@id='vfb-6-0']")).click();
//        driver.findElement(By.xpath("//input[@id='vfb-6-1']")).click();


        int selectedCheckBoxCount = 0;
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedCheckBoxCount++;
            }
        }
        if (selectedCheckBoxCount == checkBoxes.size()) {
            System.out.println("All CheckBoxes are selected.Test has failed.");
        } else {
            System.out.println("Not all CheckBoxes are selected(" + selectedCheckBoxCount +
                    " out of " + checkBoxes.size() + " has selected). Test has passed");
        }

        WebElement checkBox3 = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
        checkBox3.click();
        String actualValue = checkBox3.getAttribute("value");
        String expectedValue = "checkbox3";

        if (actualValue.equalsIgnoreCase(expectedValue)) {
            System.out.println("CheckBox3 is selected, verification has passed");

        } else {
            System.out.println("CheckBox3 is not selected, verification has failed");
            System.out.println("Selected value is " + actualValue);
        }

    }
}
