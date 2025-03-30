package com.zebrunner.carina.gui.pages.common;

import com.zebrunner.carina.gui.components.AlertHandler;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    protected ExtendedWebElement addToCartButton;
    protected ExtendedWebElement productName;
    protected ExtendedWebElement productPrice;
    protected ExtendedWebElement productDescription;

    protected AlertHandler alertHandler;

    public ProductPageBase(WebDriver driver) {
        super(driver);
        this.alertHandler = new AlertHandler(driver);
    }

    public abstract void addToCart();

    public abstract String getProductName();

    public abstract boolean isPageLoaded();

    public abstract String getProductPrice();

    public abstract String getProductDescription();

    public abstract boolean isAddToCartButtonVisible();

    public boolean isProductNameVisible() {
        return productName.isElementPresent();
    }

    public boolean isProductPriceVisible() {
        return productPrice.isElementPresent();
    }
}
