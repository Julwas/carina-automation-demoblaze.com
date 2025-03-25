package com.zebrunner.carina.gui.pages;

import com.zebrunner.carina.gui.components.AlertHandler;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//a[text()='Add to cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//h2[@class='name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//*[@class='price-container']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//*[@id='more-information']")
    private ExtendedWebElement productDescription;

    private AlertHandler alertHandler;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.alertHandler = new AlertHandler(driver);

    }

    public void addToCart() {
        addToCartButton.click();
        alertHandler.handleAlertIfPresent();
    }

    public String getProductName() {
        return productName.getText();
    }

    public boolean isPageLoaded() {
        return productName.isElementPresent() && productPrice.isElementPresent();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isElementPresent();
    }

    //NavigationCategories
    private String productNameCategories;

    public ProductPage(WebDriver driver, String productNameCategories) {
        super(driver);
        this.productNameCategories = productNameCategories;
        this.alertHandler = new AlertHandler(driver);
    }

    public String getProductNameCategories() {
        return productNameCategories;
    }
}
