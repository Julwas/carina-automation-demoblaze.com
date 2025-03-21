package com.zebrunner.carina.myGui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id="signin2")
    private ExtendedWebElement signUp;
    @FindBy(id = "sign-username")
    private ExtendedWebElement usernameField;
    @FindBy(id = "sign-password")
    private ExtendedWebElement passwordField;
    @FindBy(xpath = "//button[text()='Sign up']")
    private ExtendedWebElement signUpButton;
 @FindBy(xpath = "(//button[text()='Close'])[2]")
    private ExtendedWebElement cecondCloseButton;

    @FindBy(id = "login2")
    private ExtendedWebElement LogIn;
    @FindBy(id = "loginusername")
    private ExtendedWebElement logInUsernameField;
    @FindBy(id = "loginpassword")
    private ExtendedWebElement getLogInPasswordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private ExtendedWebElement loginButton;

    @FindBy(id = "nameofuse")
    private ExtendedWebElement userLabel;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private ExtendedWebElement alertMessage;
    public LoginPage(WebDriver driver) {
        super(driver);

    }
    public void clickSignUp(){
        signUp.click();;
    }
    public void clickLogIn(){
        LogIn.click();;
    }

    public void logIn(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
    }
    public void logInFailure(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
        handleAlertIfPresent();
    }

    public void sigIn(String username, String password){
        usernameField.type(username);
        passwordField.type(password);
        signUpButton.click();
        //handleAlertIfPresent();
    }

    public boolean isUserLoggedIn() {
        return userLabel.isElementPresent();
    }
    public  boolean isLogInVisible(){
        return LogIn.isElementPresent();
    }


    public boolean isUserExist() {
    //cecondCloseButton.click();
        //return false;
        return getAlertTextIfPresent().toLowerCase().contains("This user already exist");
    }

    public boolean isSignUpSuccessful() {
        return getAlertTextIfPresent().toLowerCase().contains("Sign up successful");
    }

    public String getAlertTextIfPresent() {
        try {
            Alert alert = getDriver().switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText); // Логируем текст алерта
            alert.accept(); // Закрываем алерт
            return alertText;
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
            return ""; // Если алерта нет, возвращаем пустую строку
        }
    }

    public boolean isErrorDisplayed() {
        return alertMessage.isElementPresent();
    }

    public void handleAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText()); // Выведет текст алерта в консоль
            alert.accept(); // Закрываем алерт, нажав "ОК"
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }
    }
    public boolean isUserFailure() {
        cecondCloseButton.click();
        return false;}
}
