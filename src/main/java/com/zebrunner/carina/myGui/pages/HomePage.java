package com.zebrunner.carina.myGui.pages;

import com.zebrunner.carina.myGui.components.AlertHandler;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static org.testng.internal.objects.InstanceCreator.newInstance;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(id = "signin2")
    private ExtendedWebElement signUp;
    @FindBy(id = "sign-username")
    private ExtendedWebElement usernameField;
    @FindBy(id = "sign-password")
    private ExtendedWebElement passwordField;
    @FindBy(xpath = "//button[text()='Sign up']")
    private ExtendedWebElement signUpButton;
    @FindBy(xpath = "(//button[text()='Close'])[2]")
    private ExtendedWebElement cecondCloseButton;
    @FindBy(xpath = "(//button[text()='Close'])[3]")
    private ExtendedWebElement loginFailureCloseButton;
    @FindBy(id = "login2")
    private ExtendedWebElement LogIn;
    @FindBy(id = "loginusername")
    private ExtendedWebElement logInUsernameField;
    @FindBy(id = "loginpassword")
    private ExtendedWebElement logInPasswordField;
    @FindBy(xpath = "//button[text()='Log in']")
    private ExtendedWebElement loginButton;
    @FindBy(id = "nameofuser")
    private ExtendedWebElement userLabel;
    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private ExtendedWebElement alertMessage;
    @FindBy(id = "logout2")
    private ExtendedWebElement logoutButton;

//products
    @FindBy(xpath = "//a[contains(text(), 'Laptops')]")
    private ExtendedWebElement laptopsCategory;

    @FindBy(xpath = "//a[contains(text(), 'Phones')]")
    private ExtendedWebElement phonesCategory;
    @FindBy(xpath = "//a[contains(text(), 'Monitors')]")
    private ExtendedWebElement monitorsCategory;

    @FindBy(xpath = "//a[@class='hrefch'][contains(text(), 'Samsung galaxy s6')]")
    private ExtendedWebElement addProductLink;

    @FindBy(id = "cartur")
    private ExtendedWebElement cartLink;

    private AlertHandler alertHandler;
    public HomePage(WebDriver driver) {
        super(driver);
        this.alertHandler = new AlertHandler(driver);
    }

    public void clickSignUp() {
        signUp.click();
        ;
    }

    public void clickLogIn() {
        LogIn.click();
        ;
    }

    public void clickLogout() {
        LOGGER.info("Waiting for Logout button to appear...");
        if (logoutButton.isElementPresent(10)) {
            LOGGER.info("Clicking on Logout button...");
            logoutButton.click();
        } else {
            LOGGER.error("Logout button is not present!");
        }
    }

    public void sigIn(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        signUpButton.click();
    }

    public void logIn(String username, String password) {
        logInUsernameField.type(username);
        logInPasswordField.type(password);
        loginButton.click();
    }

    public void logInFailure(String username, String password) {
        logInUsernameField.type(username);
        logInPasswordField.type(password);
        loginButton.click();
        alertHandler.handleAlertIfPresent();
    }

    public boolean isUserLoggedIn() {
        return userLabel.isElementPresent();
    }

    public boolean isLogInVisible() {
        return LogIn.isElementPresent();
    }

    public String getAlertTextIfPresent() {
        try {
            Alert alert = getDriver().switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();
            return alertText;
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
            return "";
        }
    }

    public void isUserFailure() {
        LOGGER.info("Waiting for close button to appear...");
        if (loginFailureCloseButton.isElementPresent(10)) {
            LOGGER.info("Clicking on Close button...");
            loginFailureCloseButton.click();
        } else {
            LOGGER.error("Close button is not present!");
        }
    }
    //
    public ProductPage selectFirstProduct() {
        addProductLink.click();
        return newInstance(ProductPage.class, driver);
    }

    public CartPage openCart() {
        cartLink.click();
        return newInstance(CartPage.class, driver);
    }
}
