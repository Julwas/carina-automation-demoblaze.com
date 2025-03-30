package com.zebrunner.carina.gui;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionTest {

    public String encryptPassword(String password, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }


    public String decryptPassword(String encrypted, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decryptedBytes);
    }


    @Test
    @MethodOwner(owner = "QA")
    public void testEncryption() throws Exception {
        String original = "securePass123";

        String key = "1234567890123456";

        String encrypted = encryptPassword(original, key);

        String decrypted = decryptPassword(encrypted, key);

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
