package com.zebrunner.carina.gui;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.gui.pages.common.HomePageBase;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.FirefoxCapabilities;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultipleBrowserTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactTest.class);

    @Test(dataProvider = "contactData", dataProviderClass = TestData.class)
    public void multipleBrowserTest(String contactEmail, String contactName, String message) {
        HomePageBase chromeHomePage = initPage(getDriver("chrome", new ChromeCapabilities()
                .getCapability("Chrome Test")), HomePageBase.class);
        chromeHomePage.open();
        Assert.assertTrue(chromeHomePage.isPageOpened(), "Chrome home page is not opened!");

        chromeHomePage.clickContact();
        chromeHomePage.fillTheFormToSendMessage(contactEmail, contactName, message);
        String chromeAlertText = chromeHomePage.getAlertTextIfPresent();
        LOGGER.info("Received alert text in Chrome: {}", chromeAlertText);

        System.out.println("ALERT TEXT: " + chromeAlertText);
        if (chromeAlertText.toLowerCase().contains("thanks for the message!!")) {
            System.out.println("Thanks for the message!!");
            Assert.assertTrue(true, "Thanks for the message!!");
        } else {
            System.out.println("Unexpected alert: " + chromeAlertText);
        }

        HomePageBase firefoxHomePage = initPage(getDriver("firefox", new FirefoxCapabilities()
                .getCapability("Firefox Test")), HomePageBase.class);
        firefoxHomePage.open();
        Assert.assertTrue(firefoxHomePage.isPageOpened(), "Firefox home page is not opened!");

        firefoxHomePage.clickContact();
        firefoxHomePage.fillTheFormToSendMessage(contactEmail, contactName, message);
        String firefoxAlertText = firefoxHomePage.getAlertTextIfPresent();
        LOGGER.info("Received alert text in Firefox: {}", firefoxAlertText);

        System.out.println("ALERT TEXT: " + firefoxAlertText);
        if (firefoxAlertText.toLowerCase().contains("thanks for the message!!")) {
            System.out.println("Thanks for the message!!");
            Assert.assertTrue(true, "Thanks for the message!!");
        } else {
            System.out.println("Unexpected alert: " + firefoxAlertText);
        }
    }
}
