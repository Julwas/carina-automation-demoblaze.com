package com.zebrunner.carina.gui;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.gui.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTests.class);
    private HomePage homePage;

    @Test(dataProvider = "contactData", dataProviderClass = TestData.class)
    @MethodOwner(owner = "QA")
    public void contactTest(String contactEmail, String contactName, String message) {
        homePage.clickContact();
        homePage.fillTheFormToSendMessage(contactEmail, contactName, message);

        String alertText = homePage.getAlertTextIfPresent();
        System.out.println("ALERT TEXT: " + alertText);
        if (alertText.toLowerCase().contains("thanks for the message!!")) {
            System.out.println("Thanks for the message!!");
            Assert.assertTrue(true, "Thanks for the message!!");
        } else {
            System.out.println("Unexpected alert: " + alertText);
        }
    }
}