package com.zebrunner.carina.myGui.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(id = "signin2")
    private WebElement signUpButton;

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "logout2")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }



    public void clickLogin() {
        loginButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }
}
