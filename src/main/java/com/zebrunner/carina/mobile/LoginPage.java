package com.zebrunner.carina.mobile;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage implements IMobileUtils {
    @FindBy(id = "com.todoist:id/btn_email")
    public ExtendedWebElement ContinueWithEmailButton;
    //xpath = "//android.widget.Button[@resource-id=\"com.todoist:id/btn_email\"]"
    @FindBy(xpath = "//android.view.View[@resource-id=\"auth_button_tag\"]/android.widget.Button")
    private ExtendedWebElement loginButton;
    // uiautomator = "new UiSelector().className("android.widget.Button").instance(0)"
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"email\"]/android.view.View")
    private ExtendedWebElement emailField;
// uiautomator = "new UiSelector().className("android.view.View").instance(2)"
    @FindBy(id = "password")
    private ExtendedWebElement passwordField;
//uiautomator = "new UiSelector().resourceId("password")"
    //xpath = "//android.widget.EditText[@resource-id="password"]"
    @FindBy(id = "com.todoist:id/email_login")
    private ExtendedWebElement LogInWithEmail;
    // uiautomator = "new UiSelector().resourceId("com.todoist:id/email_login")"
// //android.widget.TextView[@resource-id="com.todoist:id/email_login"]
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
