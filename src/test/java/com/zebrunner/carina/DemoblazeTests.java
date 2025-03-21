package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.myGui.pages.CartPage;
import com.zebrunner.carina.myGui.pages.HomePage;
import com.zebrunner.carina.myGui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoblazeTests implements IAbstractTest {
    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testLoginSuccess(String username, String password) {
        //HomePage homePage = new HomePage(getDriver());
        //homePage.open();
        //homePage.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.clickLogIn();
        pause(2);
        loginPage.logIn(username, password);

        Assert.assertTrue(loginPage.isUserLoggedIn(), "User login failed!");
    }

    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testLoginFailure(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.clickLogIn();
        pause(2);
        loginPage.logInFailure(username, password);
        loginPage.isUserFailure();
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed for invalid login!");
    }

    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testLogout(String username, String password) {//дописать и поменять loginPge tp HomePage
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn(username, password);

        homePage.clickLogout();

        Assert.assertFalse(loginPage.isUserLoggedIn(), "Logout failed!");
    }

    @Test
    public void testAddToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Перейти в категорию и добавить товар (добавить PageObject для товаров)

        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isItemInCart(), "Item not added to cart!");
    }

    @Test
    public void testPlaceOrder() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Добавить товар в корзину (использовать PageObject товаров)

        CartPage cartPage = new CartPage(getDriver());
        cartPage.placeOrder();

        // Проверить успешное сообщение о заказе
    }

    @Test
    public void testProductDetails() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Выбрать товар, перейти на страницу товара и проверить детали (создать PageObject для товаров)
    }

    @Test
    public void testCategoryNavigation() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Перейти в категорию "Phones" и проверить, что отображаются телефоны
    }

    @Test
    public void testSignup() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        //homePage.clickSignUp();

        // Ввести данные для регистрации и проверить успешное сообщение
    }

    @Test
    public void testRemoveFromCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Добавить товар, затем удалить его из корзины и проверить, что корзина пуста
    }

    @Test
    public void testPurchaseFlow() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Добавить товар в корзину, оформить заказ и проверить успешное сообщение
    }
}
