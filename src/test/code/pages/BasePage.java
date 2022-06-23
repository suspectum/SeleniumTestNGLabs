package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtil;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriverWait webDriverWait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));

    public BasePage() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

}
