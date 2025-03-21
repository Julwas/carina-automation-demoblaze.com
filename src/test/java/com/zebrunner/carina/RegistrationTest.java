package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;

import com.zebrunner.carina.myGui.pages.LoginPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RegistrationTest implements IAbstractTest {

    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testSignup(String username, String password) {
        //HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.clickSignUp();
        pause(2);
        loginPage.sigIn(username, password);

        String alertText = loginPage.getAlertTextIfPresent();
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

       /* String alertText = getAlertTextIfPresent();
        if (alertText != null) {
            if (alertText.contains("This user already exist")) {
                System.out.println("This user already exists");
            } else if (alertText.contains("Sign up successful")) {
                System.out.println("Successful registration");
            }
        } else {
            if (loginPage.isLogInVisible()) {
                System.out.println("Successful registration");
            }
            else if (loginPage.isUserExist()) {
                System.out.println("This user already exists");
            }
            else {
                System.out.println("Unknown error occurred during registration");
            }
        }*/
    }
   /* private String getAlertTextIfPresent() {
        try {
            Alert alert = getDriver().switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (NoAlertPresentException e) {
            return null;
        }
    }
}*/