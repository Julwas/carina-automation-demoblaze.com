package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.myGui.components.OrderModal;
import com.zebrunner.carina.myGui.pages.CartPage;
import com.zebrunner.carina.myGui.pages.HomePage;
import com.zebrunner.carina.myGui.pages.ProductPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartTests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTests.class);
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    @BeforeMethod
    public void startDriver(){
        homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("Home page is opened.");

        productPage = homePage.selectFirstProduct();
        productPage.addToCart();
        cartPage = homePage.openCart();

    }
    @Test
    @Parameters({"driver"})
    public void testAddToCart() {

        cartPage.isItemInCart();
        Assert.assertTrue(cartPage.isItemInCart(), "Item not added to cart!");
    }

    @Test
    public void testRemoveFromCart() {

        cartPage.isItemInCart();
        cartPage.getDeleteProduct();
        Assert.assertFalse(cartPage.isItemInCart(), "Item removed from cart!");
    }
    @Test(dataProvider = "orderData", dataProviderClass = TestData.class)
    public void testPlaceOrder(String name, String country, String city, String creditCard, String month, String year) {

        cartPage.placeOrder();
        OrderModal orderModal = new OrderModal(getDriver());
        orderModal.fillOrderForm(name, country, city, creditCard, month, year);
        orderModal.confirmOrder();
        String successMessage = orderModal.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Thank you for your purchase!")
                ,"Order was not placed successfully!");
        orderModal.ok();
    }

}
