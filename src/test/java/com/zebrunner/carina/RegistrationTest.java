package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.myGui.pages.HomePage;
import com.zebrunner.carina.myGui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class RegistrationTest implements IAbstractTest {
    /*private HomePageBase homePage;

    @BeforeSuite
    public void startDriver() {
        homePage = initPage(getDriver(), HomePageBase.class);
    }*/
    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testSignup(String username, String password) {

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        homePage.open();
        homePage.clickSignUp();
        loginPage.sigIn(username, password);

    }
}
