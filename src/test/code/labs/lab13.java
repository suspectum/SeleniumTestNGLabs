package labs;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NewCustomerPage;
import utils.PropertiesReadingUtil;


public class lab13 extends TestBase {
    /*
    POM Example TEST - Share Github Link for this
    Step 1) Go to Guru99 Demo Site http://demo.guru99.com/V4/
    Step 2) In Login page check text "Guru99 Bank" is present
    Step 3) Login into application with given credentials(you need to enter your email in order to get credentials in advance)
    Step 4) Verify that the Home page contains text as "Manger Id: mngr368294"
    Step 5) Click on new customer button and verify you are in New Customer Entry Page
    Step 6) Fill the information for new customer
    Step 7) Verify new customer added successfully

    ##// Hint-TestNG :
    //Pages : In this task you will need to create 3 pages class
    //First one for login page where you need to locate : username,password,Login and Guru99 Bank text
    //Second page is for home page, and you need to locate : text Manger Id
    //Third page is for New Customer Entry Page where you need to locate : customer information boxes such as name,adrees,gender,email,password etc.
    //Configuration File
    //store username,password , and url
    //Utils
    //use our ready utils such as reading properties,driver, browser utils
    //Base
    //use our ready testbase classes.
    //Testing
    // while testing first you will verify "Guru99 Bank" is present
    // then you need to Login into application
    // then verify Home page contains text as "Manger Id: mngr368294"
    // click on new customer tab then verify title contains New Customer Entry Page
    // fill all information to be able to create a customer // verify the message customer registered successfully.
     */


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    NewCustomerPage newCustomerPage = new NewCustomerPage();

    @Test
    public void TC1() {
        driver.get(PropertiesReadingUtil.getProperties("url"));
        String userName = PropertiesReadingUtil.getProperties("userName");
        String password = PropertiesReadingUtil.getProperties("password");
        loginPage.login(userName, password);
        String expectedMessage = "Guru99 Bank";
        String actualMessage = loginPage.getGuruText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(dependsOnMethods = "TC1")
    public void TC2() {
        String expectedMessage = "Manger Id : mngr417503";
        String actualMessage = homePage.getStatusMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        homePage.navigateNewCustomer();

        String expectedTitleWord = "New Customer Entry Page";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleWord));

        newCustomerPage.addNewCustomer();

        expectedMessage = "Customer Registered Successfully!!!";
        actualMessage = newCustomerPage.getStatusMessage();
        Assert.assertEquals(expectedMessage, actualMessage);

    }


}
