package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverUtil {


    public static WebDriver getDriver() {
        String browser = PropertiesReadingUtil.getProperties("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-site-isolation-trials");
            return new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(new ChromeOptions().setHeadless(true));
        } else if (browser.equalsIgnoreCase("firefox-headless")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(new FirefoxOptions().setHeadless(true));
        } else {
            System.out.println("Browser is not exist.");
            System.out.println("Check browser name");
            System.out.println("Browser name = " + browser);
            return null;
        }
    }
}
