package com.zebrunner.carina;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {"User1", "password1"}, // Тестовые данные для первого пользователя
               // {"user2", "password2"}, // Тестовые данные для второго пользователя
                //{"user3", "wrongpassword"} // Тестовые данные для неверного логина
        };
    }

    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {
        return new Object[][]{
                {"Lilia5", "password1"}, // Тестовые данные для регистрации 1
               // {"Lilia", "password2"} // Тестовые данные для регистрации 2
        };
    }
    @DataProvider(name = "orderData")
    public Object[][] orderDataProvider() {
        return new Object[][]{
                {"Lilia Swon", "USA", "New York", "1234567890123456", "12", "2025"},
               // {"Jane Smith", "UK", "London", "6543210987654321", "06", "2026"}
        };
    }

}
