package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.TestData;
import com.zebrunner.carina.myGui.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTests.class);
    private HomePage homePage;
    @BeforeMethod
    public void startDriver(){
        homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("Home page is opened.");
        homePage.clickLogIn();
        pause(2);
    }
    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testLoginSuccess(String username, String password) {

        homePage.logIn(username, password);

        Assert.assertTrue(homePage.isUserLoggedIn(), "User login failed!");
    }
    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testLogout(String username, String password) {
        homePage.logIn(username, password);

        Assert.assertTrue(homePage.isUserLoggedIn(), "User login failed!");
        homePage.clickLogout();
        Assert.assertTrue(homePage.isLogInVisible());
    }
    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void testLoginFailure(String username, String password) {
        homePage.logInFailure(username, password);
        homePage.isUserFailure();
        Assert.assertTrue(homePage.isLogInVisible(), "Error message not displayed for invalid login!");
    }
}
