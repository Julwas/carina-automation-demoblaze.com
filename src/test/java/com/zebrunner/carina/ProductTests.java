package com.zebrunner.carina;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.TestData;
import com.zebrunner.carina.myGui.pages.HomePage;
import com.zebrunner.carina.myGui.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductTests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTests.class);
    private  HomePage homePage;
    @BeforeMethod
    public void startDriver(){
        homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("Home page is opened.");
    }

    @Test
    public void testProductDetails() {
        LOGGER.info("Test started: testProductDetails");
        ProductPage productPage = homePage.selectFirstProduct();
        Assert.assertTrue(productPage.isPageLoaded(), "Product page is not loaded!");
        String productName = productPage.getProductName();
        Assert.assertNotNull(productName, "Product name is not displayed!");
        Assert.assertFalse(productName.isEmpty(), "Product name is empty!");
        LOGGER.info("Product name displayed: {}", productName);
        String productPrice = productPage.getProductPrice();
        Assert.assertNotNull(productPrice, "Product price is not displayed!");
        Assert.assertFalse(productPrice.isEmpty(), "Product price is empty!");
        LOGGER.info("Product price displayed: {}", productPrice);
        String productDescription = productPage.getProductDescription();
        Assert.assertNotNull(productDescription, "Product description is not displayed!");
        Assert.assertFalse(productDescription.isEmpty(), "Product description is empty!");
        LOGGER.info("Product description displayed: {}", productDescription);
        boolean isAddToCartButtonVisible = productPage.isAddToCartButtonVisible();
        Assert.assertTrue(isAddToCartButtonVisible, "Add to Cart button is not visible!");
        LOGGER.info("Add to Cart button visible: {}", isAddToCartButtonVisible);
        LOGGER.info("Test finished: testProductDetails");
    }
@Test(dataProvider = "categoryData", dataProviderClass = TestData.class)
    public void NavigationCategoryTest(String category, List<String> expectedProducts){

    homePage.selectCategory(category);
    LOGGER.info("Selected category: {}", category);

    List<ProductPage> actualProducts = homePage.getDisplayedProducts();
    Assert.assertFalse(actualProducts.isEmpty(), "No products displayed in the category!");

    homePage.verifyProductsBelongToCategory(actualProducts, expectedProducts);

    LOGGER.info("Test passed: NavigationCategoryTest");

}}

