package com.zebrunner.carina;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class TestData {
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {"User1", "password1"},
                // {"user2", "password2"},
                //{"user3", "wrongpassword"}
        };
    }
    @DataProvider(name = "contactData")
    public static Object[][] contactData() {
        return new Object[][]{
                {"email1", "Name1", " Some message"},
                // {"email2", "Name2", " Some message2"},
                //{"email3", "Name3", " Some message3"}
        };
    }


    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {
        return new Object[][]{
                {"Lilia555", "password1"},
                 {"Lilia", "password2"}
        };
    }
    @DataProvider(name = "orderData")
    public Object[][] orderDataProvider() {
        return new Object[][]{
                {"Lilia Swon", "USA", "New York", "1234567890123456", "12", "2025"},
                // {"Jane Smith", "UK", "London", "6543210987654321", "06", "2026"}
        };
    }
    @DataProvider(name = "categoryData")
    public Object[][] categoryDataProvider() {
        return new Object[][]{
                {"Phones", Arrays.asList("Samsung galaxy s6", "Samsung galaxy s7", "Nokia lumia 1520", "Nexus 6",
                        "Iphone 6 32gb", "Sony xperia z5", "HTC One M9")},
                 {"Laptops", Arrays.asList("Sony vaio i5", "MacBook air", "Dell i7 8gb")},
                //{"Monitors", Arrays.asList("Apple monitor 24", "ASUS Full HD")}
        };

    }}
