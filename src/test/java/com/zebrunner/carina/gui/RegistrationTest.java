package com.zebrunner.carina.gui;

import com.zebrunner.carina.core.IAbstractTest;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.gui.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest implements IAbstractTest {
    private HomePage homePage;
    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    @MethodOwner(owner = "QA")
    public void testSignup(String username, String password) {
        homePage.clickSignUp();
        pause(2);
        homePage.sigIn(username, password);

        String alertText = homePage.getAlertTextIfPresent();
        System.out.println("ALERT TEXT: " + alertText);
        if (alertText.toLowerCase().contains("sign up successful")) {
            System.out.println("Successful registration");
            Assert.assertTrue(true, "Successful registration");
        } else if (alertText.toLowerCase().contains("this user already exist")) {
            System.out.println("This user already exist");
            Assert.assertTrue(true, "This user already exist");
        } else {
            Assert.fail("Unexpected alert: " + alertText);
        }
    }
}
