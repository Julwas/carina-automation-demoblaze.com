package com.zebrunner.carina.gui;

import com.zebrunner.carina.core.AbstractTest;

import com.zebrunner.carina.gui.pages.HomePage;
import org.testng.annotations.Test;

public class BaseTest extends AbstractTest {
    @Test
    public void baseTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
    }
}
