package com.zebrunner.carina.gui;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.gui.pages.desktop.AmazonHomePage;
import com.zebrunner.carina.gui.pages.desktop.AmazonLocalePage;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import org.testng.Assert;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

public class AmazonLocalizationTest  implements IAbstractTest {

    @BeforeClass
    public void testLocaleLoad() {
        Locale locale = L10N.getLocale();
        String loadedLocale = locale.getLanguage() + "_" +  locale.getCountry();
        String configLocale = Configuration.getRequired(WebDriverConfiguration.Parameter.LOCALE);
        Assert.assertEquals(loadedLocale, configLocale, "Loaded locale doesn't match the configured locale.");
    }

    @Test(dataProvider = "locales", dataProviderClass = TestData.class)
    @TestLabel(name = "feature", value = "l10n")
    public void testNavBarText(String locale) {
        AmazonHomePage amazonHomePage = new AmazonHomePage(getDriver());
        amazonHomePage.open();
        Assert.assertTrue(amazonHomePage.isPageOpened(), "Home page is not opened");

        L10N.setLocale(locale);
        L10N.load();

        AmazonLocalePage amazonLocalePage = amazonHomePage.goToAmazonLocalePage(getDriver());
        Assert.assertEquals(L10N.getText("AmazonLocalePage.shopByCategory"), amazonHomePage.getShopByCategoryText());
        Assert.assertEquals(L10N.getText("AmazonLocalePage.todayDeals"), amazonHomePage.getTodayDealsText());
        L10N.assertAll();
    }

    @Test(dataProvider = "locales", dataProviderClass = TestData.class)
    @TestLabel(name = "feature", value = "l10n")
    public void testFooterLinks(String locale) {
        AmazonHomePage amazonHomePage = new AmazonHomePage(getDriver());
        amazonHomePage.open();
        Assert.assertTrue(amazonHomePage.isPageOpened(), "Home page is not opened");

        L10N.setLocale(locale);
        L10N.load();

        AmazonLocalePage amazonLocalePage = amazonHomePage.goToAmazonLocalePage(getDriver());
        Assert.assertEquals(L10N.getText("AmazonLocalePage.aboutUsFooter"), amazonLocalePage.getAboutUsFooterText());
        Assert.assertEquals(L10N.getText("AmazonLocalePage.contactUsFooter"), amazonLocalePage.getContactUsFooterText());
        L10N.assertAll();
    }

    @Test(dataProvider = "locales", dataProviderClass = TestData.class)
    @TestLabel(name = "feature", value = "l10n")
    public void testSignInButtonText(String locale) {
        AmazonHomePage amazonHomePage = new AmazonHomePage(getDriver());
        amazonHomePage.open();
        Assert.assertTrue(amazonHomePage.isPageOpened(), "Home page is not opened");

        L10N.setLocale(locale);
        L10N.load();

        AmazonLocalePage amazonLocalePage = amazonHomePage.goToAmazonLocalePage(getDriver());
        Assert.assertEquals(L10N.getText("AmazonLocalePage.signInButton"), amazonHomePage.getSignInButtonText());
    }

    @Test(dataProvider = "locales", dataProviderClass = TestData.class)
    @TestLabel(name = "feature", value = "l10n")
    public void testPageTitle(String locale) {
        AmazonHomePage amazonHomePage = new AmazonHomePage(getDriver());
        amazonHomePage.open();
        Assert.assertTrue(amazonHomePage.isPageOpened(), "Home page is not opened");

        L10N.setLocale(locale);
        L10N.load();

        AmazonLocalePage amazonLocalePage = amazonHomePage.goToAmazonLocalePage(getDriver());
        Assert.assertEquals(amazonLocalePage.getTitle(), L10N.getText("AmazonLocalePage.pageTitle"));
    }

    @Test(dataProvider = "locales", dataProviderClass = TestData.class)
    @TestLabel(name = "feature", value = "l10n")
    public void testSearchButtonText(String locale) {
        AmazonHomePage amazonHomePage = new AmazonHomePage(getDriver());
        amazonHomePage.open();
        Assert.assertTrue(amazonHomePage.isPageOpened(), "Home page is not opened");

        L10N.setLocale(locale);
        L10N.load();

        AmazonLocalePage amazonLocalePage = amazonHomePage.goToAmazonLocalePage(getDriver());
        Assert.assertEquals(L10N.getText("AmazonLocalePage.searchButton"), amazonLocalePage.getSearchButtonText());
    }

    @Test(dataProvider = "locales", dataProviderClass = TestData.class)
    @TestLabel(name = "feature", value = "l10n")
    public void testCartButtonText(String locale) {
        AmazonHomePage amazonHomePage = new AmazonHomePage(getDriver());
        amazonHomePage.open();
        Assert.assertTrue(amazonHomePage.isPageOpened(), "Home page is not opened");

        L10N.setLocale(locale);
        L10N.load();

        AmazonLocalePage amazonLocalePage = amazonHomePage.goToAmazonLocalePage(getDriver());
        Assert.assertEquals(L10N.getText("AmazonLocalePage.cartButton"), amazonLocalePage.getCartButtonText());
    }
}
