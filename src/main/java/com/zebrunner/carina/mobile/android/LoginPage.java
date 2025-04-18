package com.zebrunner.carina.mobile.android;

import com.zebrunner.carina.mobile.common.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends LoginPageBase {
    @FindBy(id = "com.todoist:id/btn_email")
    public ExtendedWebElement ContinueWithEmailButton;

    @FindBy(xpath = "//*[@resource-id=\"auth_button_tag\"]/android.widget.Button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@resource-id=\"email\"]/*")
    private ExtendedWebElement emailField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "com.todoist:id/email_login")
    private ExtendedWebElement LogInWithEmail;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        emailField.type(email);
        passwordField.type(password);
        loginButton.click();
    }
    public void LogInWithEmael(){
        ContinueWithEmailButton.click();
        LogInWithEmail.click();
    }

}
