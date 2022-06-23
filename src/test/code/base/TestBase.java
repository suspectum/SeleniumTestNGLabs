package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverUtil;
import utils.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverUtil.getDriver(); //  for parallel testing
//        driver = DriverUtil.getDriver(); // same driver for all
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closing() {
        driver.quit();
//        DriverUtil.closeDriver();

    }

}
