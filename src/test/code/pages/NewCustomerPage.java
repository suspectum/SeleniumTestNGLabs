package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;

public class NewCustomerPage extends BasePage {

    Faker faker = new Faker();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");


    @FindBy(name = "name")
    public WebElement customerNameBox;

    @FindBy(xpath = "//input[@name='rad1'][1]")
    public WebElement genderRadioButton;

    @FindBy(id = "dob")
    public WebElement dateOfBirthBox;

    @FindBy(name = "addr")
    public WebElement addressBox;

    @FindBy(name = "city")
    public WebElement cityBox;

    @FindBy(name = "state")
    public WebElement stateBox;

    @FindBy(name = "pinno")
    public WebElement pinBox;

    @FindBy(name = "telephoneno")
    public WebElement phoneBox;

    @FindBy(name = "emailid")
    public WebElement emailBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(name = "sub")
    public WebElement submitButton;


    @FindBy(xpath = "//*[contains(text(), 'Successfully')]")
    private WebElement statusMessage;

    public void addNewCustomer() {
        customerNameBox.sendKeys(faker.name().firstName());
        genderRadioButton.click();
        dateOfBirthBox.sendKeys(sdf.format(faker.date().birthday()));
        addressBox.sendKeys(faker.address().streetAddress());
        cityBox.sendKeys(faker.address().city());
        stateBox.sendKeys(faker.address().state());
        pinBox.sendKeys(String.valueOf(faker.number().randomNumber(6, true)));
        phoneBox.sendKeys(String.valueOf(faker.number().randomNumber(10, true)));
        emailBox.sendKeys(faker.name().firstName().toLowerCase() + "@" + faker.name().firstName().toLowerCase() + ".com");
        passwordBox.sendKeys(String.valueOf(faker.number().randomNumber(6, true)));
        submitButton.click();
    }

    public String getStatusMessage() {
        return statusMessage.getText();
    }


}
