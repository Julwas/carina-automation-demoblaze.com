package com.zebrunner.carina.myGui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//button[text()='Place Order']")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//tr[@class='success']")
    private List<ExtendedWebElement> cartItems;



    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemInCart() {

        return !cartItems.isEmpty();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
}
