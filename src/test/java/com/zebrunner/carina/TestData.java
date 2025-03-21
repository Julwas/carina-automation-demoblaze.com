package com.zebrunner.carina;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {"user1", "password1"}, // Тестовые данные для первого пользователя
                {"user2", "password2"}, // Тестовые данные для второго пользователя
                {"user3", "wrongpassword"} // Тестовые данные для неверного логина
        };
    }

    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {
        return new Object[][]{
                {"Lilia5", "password1"}, // Тестовые данные для регистрации 1
                {"Lilia", "password2"} // Тестовые данные для регистрации 2
        };
    }

    @DataProvider(name = "orderData")
    public static Object[][] orderData() {
        return new Object[][]{
                {"product1", 1}, // Тестовые данные для заказа 1
                {"product2", 2}  // Тестовые данные для заказа 2
        };
    }
}
