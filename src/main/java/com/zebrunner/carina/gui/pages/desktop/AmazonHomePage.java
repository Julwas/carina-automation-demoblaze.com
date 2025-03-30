package com.zebrunner.carina.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends AbstractPage {
    @FindBy(xpath = "//*[@class = 'nav-search-scope nav-sprite']")
    private ExtendedWebElement shopByCategory;

    @FindBy(xpath = "//a[@class = 'nav-a  ']")
    private ExtendedWebElement todayDeals;

    @FindBy(xpath = "//a[@id='nav-link-accountList-nav-line-1']")
    private ExtendedWebElement signInButton;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get("https://www.amazon.com");
    }

    public boolean isPageOpened() {
        return shopByCategory.isPresent() && todayDeals.isPresent();
    }

    public AmazonLocalePage goToAmazonLocalePage(WebDriver driver) {
        shopByCategory.click();
        return new AmazonLocalePage(driver);
    }

    public String getSignInButtonText() {
        return signInButton.getText();
    }

    public String getShopByCategoryText() {
        return shopByCategory.getText();
    }

    public String getTodayDealsText() {
        return todayDeals.getText();}
}
