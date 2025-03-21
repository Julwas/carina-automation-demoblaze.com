package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.myGui.components.OrderModal;
import com.zebrunner.carina.myGui.pages.CartPage;
import com.zebrunner.carina.myGui.pages.HomePage;
import com.zebrunner.carina.myGui.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoblazeTests implements IAbstractTest {
    /*private  HomePage homePage;
    @BeforeMethod
    public void startDriver(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
    }
    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testLoginSuccess(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickLogIn();
        pause(2);
        homePage.logIn(username, password);

        Assert.assertTrue(homePage.isUserLoggedIn(), "User login failed!");
    }
   @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testLogout(String username, String password) {//дописать и поменять loginPge tp HomePage
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickLogIn();
        homePage.logIn(username, password);

        Assert.assertTrue(homePage.isUserLoggedIn(), "User login failed!");
        homePage.clickLogout();
        Assert.assertTrue(homePage.isLogInVisible());
    }
    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void testLoginFailure(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickLogIn();
        pause(2);
        homePage.logInFailure(username, password);
        homePage.isUserFailure();
        Assert.assertTrue(homePage.isLogInVisible(), "Error message not displayed for invalid login!");
    }

   @Test
   @Parameters({"driver"})
    public void testAddToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
       ProductPage productPage = homePage.selectFirstProduct();
       productPage.addToCart();
        CartPage cartPage = homePage.openCart();
        cartPage.placeOrder();
        Assert.assertTrue(cartPage.isItemInCart(), "Item not added to cart!");
    }*/

    @Test(dataProvider = "orderData", dataProviderClass = TestData.class)
    public void testPlaceOrder(String name, String country, String city, String creditCard, String month, String year) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductPage productPage = homePage.selectFirstProduct();
        productPage.addToCart();
        CartPage cartPage = homePage.openCart();
        cartPage.placeOrder();
        OrderModal orderModal = new OrderModal(getDriver());
        orderModal.fillOrderForm(name, country, city, creditCard, month, year);
        orderModal.confirmOrder();

        // Проверка успешного сообщения о завершении заказа
        String successMessage = orderModal.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Thank you for your purchase!"), "Order was not placed successfully!");
        orderModal.ok();
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
