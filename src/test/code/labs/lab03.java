package labs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class lab03 {
/*
//TASK: Google search
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write “apple” in search box
//4- Click google search button
//5- Verify title:
//Expected: Title should start with "apple" word
//6-navigate back
//7-write cherry in search box
//8-verify title contains cherry.



//TASK2: Google Feeling lucky button
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write "apple" in search box
//click i am feeling lucky button
//Verify title contains Apple

//go to https://opensource-demo.orangehrmlive.com/
//locate user name and send user name, (username=Admin)
//locate user password and send password (password=admin123)
//click on the login button
*/


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https:google.com");
        String expectedTitleWord = "apple";
        driver.findElement(By.name("q")).sendKeys(expectedTitleWord);

        driver.findElement(By.name("btnK")).click();

        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedTitleWord)) {
            System.out.println("Google title verification is passed.");

        } else {
            System.out.println("Google title verification is failed.");
            System.out.println("Actual title is " + actualTitle);
        }

        driver.navigate().back();
        expectedTitleWord = "cherry";
        driver.findElement(By.name("q")).sendKeys(expectedTitleWord, Keys.ENTER);
        actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedTitleWord)) {
            System.out.println("Google title verification is passed.");
        } else {
            System.out.println("Google title verification is failed.");
            System.out.println("Actual title is " + actualTitle);
        }

    }
}
