package com.zebrunner.carina.gui;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.util.Base64;
import java.util.Locale;

import org.testng.annotations.Optional;

public class FunctionalTest implements IAbstractTest {

    @Test
    @Parameters({"browser"})
    @MethodOwner(owner = "QA")
    public void testMultipleBrowsers(@Optional("chrome") String browser) {
        System.out.println("Running test on: " + browser);
        Assert.assertNotNull(browser);
    }

    public String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public String decryptPassword(String encrypted) {
        return new String(Base64.getDecoder().decode(encrypted));
    }

    @Test
    @MethodOwner(owner = "QA")
    public void testEncryption() {
        String original = "securePass123";
        String encrypted = encryptPassword(original);
        String decrypted = decryptPassword(encrypted);

        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        Assert.assertEquals(original, decrypted);
    }

    @Test(dataProvider = "locales", dataProviderClass = TestData.class)
    @MethodOwner(owner = "QA")
    public void testLocalization(Locale locale) {
        System.out.println("Testing locale: " + locale);
        Assert.assertNotNull(locale);
    }
}
