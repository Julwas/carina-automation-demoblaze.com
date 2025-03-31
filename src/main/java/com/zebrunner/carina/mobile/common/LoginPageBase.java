package com.zebrunner.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void login(String email, String password);

    public abstract void LogInWithEmael();
}
