package labs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab02 {
/*
//TC #1: Facebook title verification
//Task - 1
//Open Chrome Browser
//Go to https://www.facebook.com
//Verify title: Expected: "Facebook - Log In or Sign Up"
//Task - 2
//Open Chrome Browser
//Go to google
//Navigate back
//Navigate forward
//Navigate to https://www.amazon.com
//Verify title contains : Smile

Second Task:
  // Go to https://www.etsy.com/
 // Maximize window
 // Verify title doesnt contains "Smile"
 // Verify Current Url
 // Go to https://www.amazon.com/
 // Verify title
 // Verify Current Url
 // Navigate Back
 // Refresh
 // Quit browser
*/

    public static void main(String[] args) {
//      Task - 1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Facebook title verification is passed.");
        } else {
            System.out.println("Facebook title verification is failed.");
            System.out.println("Browser title is " + actualTitle);
            System.out.println("Expected title is " + expectedTitle);

        }

//      Task - 2
        driver.get("https://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to("https://www.amazon.com");

        String expectedTitleWord = "Smile";
        actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleWord)) {
            System.out.println("Amazon title verification is passed.");
        } else {
            System.out.println("Amazon title verification is failed.");
            System.out.println("Current title is " + actualTitle
                    + " current title is " + expectedTitleWord);

        }

//      Task - 3
        String url1 = "https://www.etsy.com/";
        driver.get(url1);
        driver.manage().window().maximize();

        actualTitle = driver.getTitle();

        if (!actualTitle.contains(expectedTitleWord)) {
            System.out.println("Etsy title verification is passed.");
        } else {
            System.out.println("Etsy title verification is failed.");
            System.out.println("Current title contains Smile");
        }

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(url1)) {
            System.out.println("Etsy url verification is passed.");
        } else {
            System.out.println("Etsy title verification is failed.");
            System.out.println("Current url is " + currentUrl
                    + " expected url is " + url1);
        }

        String url2 = "https://www.amazon.com/";
        driver.get(url2);
        expectedTitleWord = "Smile";
        actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleWord)) {
            System.out.println("Amazon title verification is passed.");
        } else {
            System.out.println("Amazon title verification is failed.");
            System.out.println("Current title is " + actualTitle);
        }


        currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(url2)) {
            System.out.println("Amazon url verification is passed.");
        } else {
            System.out.println("Amazon title verification is failed.");
            System.out.println("Current url is " + currentUrl);
        }

        driver.navigate().back();
        driver.navigate().refresh();
        driver.close();

    }

}
