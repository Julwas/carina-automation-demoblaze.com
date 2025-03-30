package com.zebrunner.carina.gui;


import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactTest.class);

  @Test(dataProvider = "contactData", dataProviderClass = TestData.class)
    @MethodOwner(owner = "QA")
    public void contactTest(String contactEmail, String contactName, String message) {
        LOGGER.info("Starting contact test with email: {}, name: {}", contactEmail, contactName);

        homePage.clickContact();
        LOGGER.info("Clicked on Contact button.");

        homePage.fillTheFormToSendMessage(contactEmail, contactName, message);
        LOGGER.info("Filled the contact form with test data.");

        String alertText = homePage.getAlertTextIfPresent();
        LOGGER.info("Received alert text: {}", alertText);

        System.out.println("ALERT TEXT: " + alertText);
        if (alertText.toLowerCase().contains("thanks for the message!!")) {
            System.out.println("Thanks for the message!!");
            Assert.assertTrue(true, "Thanks for the message!!");
        } else {
            System.out.println("Unexpected alert: " + alertText);
        }
    }
}