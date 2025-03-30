package com.zebrunner.carina.gui;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.gui.components.OrderModal;
import com.zebrunner.carina.gui.pages.desktop.CartPage;
import com.zebrunner.carina.gui.pages.desktop.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartTests extends BaseTest implements IAbstractTest {
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    public void addProductToCart() {
        productPage = homePage.selectFirstProduct();
        productPage.addToCart();
        cartPage = homePage.openCart();
    }

    @Test
    @Parameters({"driver"})
    @MethodOwner(owner = "QA")
    public void testAddToCart() {

        cartPage.isItemInCart();
        Assert.assertTrue(cartPage.isItemInCart(), "Item not added to cart!");
    }

    @Test
    @MethodOwner(owner = "QA")
    public void testRemoveFromCart() {

        cartPage.isItemInCart();
        cartPage.getDeleteProduct();
        Assert.assertFalse(cartPage.isItemInCart(), "Item removed from cart!");
    }

    @Test(dataProvider = "orderData", dataProviderClass = TestData.class)
    @MethodOwner(owner = "QA")
    public void testPlaceOrder(String name, String country, String city, String creditCard, String month, String year) {

        cartPage.placeOrder();
        OrderModal orderModal = new OrderModal(getDriver());
        orderModal.fillOrderForm(name, country, city, creditCard, month, year);
        orderModal.confirmOrder();
        String successMessage = orderModal.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Thank you for your purchase!")
                , "Order was not placed successfully!");
        orderModal.ok();
    }

}
