package com.zebrunner.carina.gui;

import com.zebrunner.carina.core.AbstractTest;


import com.zebrunner.carina.gui.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    protected HomePage homePage;
    @BeforeMethod
    public void startDriver(){
        homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("Home page is opened.");
    }
    @AfterMethod
    public void stopDriver() {
        getDriver().quit();
        LOGGER.info("Driver is closed.");
    }
}
