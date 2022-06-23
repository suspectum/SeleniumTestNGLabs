package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "uid")
    private WebElement userNameBox;

    @FindBy(name = "password")
    private WebElement passwordBox;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    @FindBy(className = "barone")
    private WebElement guruText;

    public void login(String userName, String password) {
        userNameBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

    public String getGuruText() {
        return guruText.getText();
    }
}
