package com.zebrunner.carina.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AmazonLocalePage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='a-size-large a-text-normal']")
    private ExtendedWebElement contentTitle;

    @FindBy(xpath = "//span[@id='nav-cart']")
    private ExtendedWebElement cartButton;
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private ExtendedWebElement searchBox;
    @FindBy(xpath = "//a[contains(text(),'About Us')]")
    private ExtendedWebElement aboutUsFooter;

    @FindBy(xpath = "//a[contains(text(),'Contact Us')]")
    private ExtendedWebElement contactUsFooter;

    public AmazonLocalePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public String getContentTitleLabelText() {
        return contentTitle.getText();
    }

    public String getCartButtonText() {
        return cartButton.getText();
    }

    public String getAboutUsFooterText() {
        return aboutUsFooter.getText();
    }

    public String getContactUsFooterText() {
        return contactUsFooter.getText();
    }
    public String getSearchButtonText() {
        return searchBox.getAttribute("placeholder");
    }

}
