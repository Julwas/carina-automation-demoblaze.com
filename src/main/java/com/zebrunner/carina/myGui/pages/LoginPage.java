package com.zebrunner.carina.myGui.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "signin2")
    private WebElement signUp;
    @FindBy(id = "sign-username")
    private WebElement usernameField;
    @FindBy(id = "sign-password")
    private WebElement passwordField;
    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpButton;
 @FindBy(xpath = "(//button[text()='Close'])[2]")
    private WebElement cecondCloseButton;

    @FindBy(id = "login2")
    private WebElement LogIn;
    @FindBy(id = "loginusername")
    private WebElement logInUsernameField;
    @FindBy(id = "loginpassword")
    private WebElement getLogInPasswordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(id = "nameofuse")
    private WebElement userLabel;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private WebElement alertMessage;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    public void sigIn(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signUpButton.click();
    }

    public boolean isUserLoggedIn() {
        return userLabel.isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return alertMessage.isDisplayed();
    }
}
