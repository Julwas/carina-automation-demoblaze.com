package com.zebrunner.carina.myGui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderModal extends AbstractUIObject {
    @FindBy(id = "name")
    private ExtendedWebElement nameField;

    @FindBy(id = "country")
    private  ExtendedWebElement countryField;

    @FindBy(id = "city")
    private  ExtendedWebElement cityField;

    @FindBy(id = "card")
    private  ExtendedWebElement creditCardField;

    @FindBy(id = "month")
    private  ExtendedWebElement monthField;

    @FindBy(id = "year")
    private  ExtendedWebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private  ExtendedWebElement purchaseButton;

    @FindBy(xpath = "//div[contains(@class, 'sweet-alert')]//h2")
    private  ExtendedWebElement successMessage;

@FindBy(xpath = "//button[text()='OK']")
    private  ExtendedWebElement okButton;


    public OrderModal(WebDriver driver) {
        super(driver);
    }

    public OrderModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void fillOrderForm(String name, String country, String city, String creditCard, String month, String year) {
        nameField.type(name);
        countryField.type(country);
        cityField.type(city);
        creditCardField.type(creditCard);
        monthField.type(month);
        yearField.type(year);
    }

    public void confirmOrder() {
        purchaseButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
    public void ok(){
        okButton.click();
    }

}
