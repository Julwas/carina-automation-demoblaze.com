package com.zebrunner.carina.gui.pages.common;

import com.zebrunner.carina.gui.components.AlertHandler;
import com.zebrunner.carina.gui.pages.desktop.CartPage;
import com.zebrunner.carina.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    protected ExtendedWebElement signUp;
    protected ExtendedWebElement usernameField;
    protected ExtendedWebElement passwordField;
    protected ExtendedWebElement signUpButton;
    protected ExtendedWebElement loginButton;
    protected ExtendedWebElement logInUsernameField;
    protected ExtendedWebElement logInPasswordField;
    protected ExtendedWebElement userLabel;
    protected ExtendedWebElement logoutButton;
    protected ExtendedWebElement cartLink;
    protected ExtendedWebElement contactLink;
    protected ExtendedWebElement contacEmailField;
    protected ExtendedWebElement contacNameField;
    protected ExtendedWebElement contacMessageField;
    protected ExtendedWebElement sendMessageButton;


    protected ExtendedWebElement laptopsCategory;
    protected ExtendedWebElement phonesCategory;
    protected ExtendedWebElement monitorsCategory;


    protected ExtendedWebElement addProductLink;


    protected AlertHandler alertHandler;

    public HomePageBase(WebDriver driver) {
        super(driver);
        this.alertHandler = new AlertHandler(driver);
    }

    public abstract void clickSignUp();

    public abstract void signUp(String username, String password);

    public abstract void clickLogIn();

    public abstract void logIn(String username, String password);

    public abstract void logOut();

    public abstract boolean isUserLoggedIn();

    public abstract String getAlertTextIfPresent();

    public abstract void clickContact();

    public abstract void fillTheFormToSendMessage(String contactEmail, String contactName, String message);

    public abstract void selectCategory(String category);

    public abstract List<ProductPage> getDisplayedProducts();

    public abstract void verifyProductsBelongToCategory(List<ProductPage> actualProducts, List<String> expectedProducts);

    public boolean isLogInVisible() {
        return loginButton.isElementPresent();
    }

    public ProductPage selectFirstProduct() {
        addProductLink.click();

        return null;
    }

    public CartPage openCart() {
        cartLink.click();
        return null;
    }
}
