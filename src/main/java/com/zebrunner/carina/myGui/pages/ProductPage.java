package com.zebrunner.carina.myGui.pages;

import com.zebrunner.carina.myGui.components.AlertHandler;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//a[text()='Add to cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//h2[@class='name']")
    private ExtendedWebElement productName;

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

}
