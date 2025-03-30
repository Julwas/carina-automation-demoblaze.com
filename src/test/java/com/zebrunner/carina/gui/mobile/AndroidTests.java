package com.zebrunner.carina.gui.mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.mobile.android.HomePage;
import com.zebrunner.carina.mobile.android.LoginPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AndroidTests implements IAbstractTest, IMobileUtils {
    @Test
    public void testLoginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LogInWithEmael();
        loginPage.login("test@example.com", "wrongpassword");
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isAddTaskButtonPresent(),
                "There is no error message!");
    }

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LogInWithEmael();
        loginPage.login("me-juli@yandec.by", "12345Abc!");
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isAddTaskButtonPresent(),
                "Login failed! The 'Add task' button was not found.");
    }

    @Test
    public void testAddTask() {
        HomePage homePage = new HomePage(getDriver());
        homePage.addTask("Task1");
        Assert.assertTrue(homePage.isTaskPresent("Task1"), "The task has not been added!");
    }

    @Test
    public void testDeleteTask() {
        HomePage homePage = new HomePage(getDriver());
        homePage.taskDelete();
        Assert.assertFalse(homePage.isTaskPresent("Task1"), "The task has not been deleted!");
    }

    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(getDriver());
        homePage.logoOutMethod();
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.ContinueWithEmailButton.isElementPresent());
    }

    @Test
    public void testHomeScreenVisible() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isAddTaskButtonPresent(), "The home screen is not displayed!");
    }

    @Test
    public void testCheckTaskList() {
        HomePage homePage = new HomePage(getDriver());
        homePage.toDayShow();
        Assert.assertTrue(homePage.isListOfTaskPresent(), "There is no task list!");
    }

   @Test
    public void testAddMultipleTasks() {
        HomePage homePage = new HomePage(getDriver());
        homePage.addTask("Task2");
        homePage.addTask("Task3");
        Assert.assertTrue(homePage.isTaskPresent("Task2"), "The first task has not been added!");
        Assert.assertTrue(homePage.isTaskPresent("Task3"), "The first task has not been added");
    }
    @Test
    public void testAppRestart() {
        getDriver().quit();
        getDriver();
        ((AndroidDriver) getDriver()).activateApp("com.todoist");
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.ContinueWithEmailButton.isElementPresent(),
                "The application did not restart correctly!");
    }

}
