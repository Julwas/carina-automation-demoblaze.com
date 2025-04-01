package com.zebrunner.carina.gui.pages.desktop;

import com.zebrunner.carina.gui.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CartPageBase {
    @FindBy(xpath = "//button[text()='Place Order']")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//tr[@class='success']")
    private List<ExtendedWebElement> cartItems;

    @FindBy(xpath = "//a[text()='Delete']")
    private ExtendedWebElement deleteButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteProduct() {
        deleteButton.click();
    }

    public boolean isItemInCart() {

        return !cartItems.isEmpty();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
}
