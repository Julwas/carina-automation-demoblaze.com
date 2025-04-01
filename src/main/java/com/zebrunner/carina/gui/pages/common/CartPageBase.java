package com.zebrunner.carina.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {

    protected ExtendedWebElement placeOrderButton;
    protected ExtendedWebElement deleteButton;
    protected List<ExtendedWebElement> cartItems;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickDeleteProduct();

    public abstract boolean isItemInCart();

    public abstract void placeOrder();

    public boolean isPlaceOrderButtonVisible() {
        return placeOrderButton.isElementPresent();
    }

    public boolean isDeleteButtonVisible() {
        return deleteButton.isElementPresent();
    }

    public int getCartItemCount() {
        return cartItems.size();
    }
}
