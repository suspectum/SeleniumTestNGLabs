package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Manger Id')]")
    private WebElement statusMessage;

    @FindBy(linkText = "New Customer")
    public WebElement newCustomerLink;

    public String getStatusMessage() {
        return statusMessage.getText();
    }


    public void navigateNewCustomer() {
        newCustomerLink.click();
    }


}
