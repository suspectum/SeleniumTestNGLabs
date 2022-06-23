package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {
    public static void wait(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void resolveAllAlerts(WebDriver driver, int timeout, boolean accept) {
        while (isAlertPresent(driver, timeout)) {
            resolveAlert(driver, accept);
        }
    }

    private static boolean isAlertPresent(WebDriver driver, int timeout) {
        try {
            Alert alert = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.alertIsPresent());
            if (alert != null) {
                return true;
            } else {
                throw new TimeoutException();
            }
        } catch (TimeoutException e) {
            // log the exception;
            return false;
        }
    }

    private static void resolveAlert(WebDriver driver, boolean accept) {
        if (accept) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
    }
}
