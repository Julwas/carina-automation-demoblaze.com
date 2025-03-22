package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;

import com.zebrunner.carina.TestData;
import com.zebrunner.carina.myGui.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;
public class RegistrationTest implements IAbstractTest {

    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testSignup(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
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
            Assert.assertTrue(true,"This user already exist");
        } else {
            Assert.fail("Unexpected alert: " + alertText);
        }
    }
    }
