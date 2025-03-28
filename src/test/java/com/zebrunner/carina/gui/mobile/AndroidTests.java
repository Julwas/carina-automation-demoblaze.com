package com.zebrunner.carina.gui.mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.gui.TestData;
import com.zebrunner.carina.mobile.HomePage;
import com.zebrunner.carina.mobile.LoginPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
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
        loginPage.login("valid@example.com", "correctpassword");
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isAddTaskButtonPresent(),
                "Login failed! The 'Add task' button was not found.");
    }

    @Test(dataProvider = "taskName", dataProviderClass = TestData.class)
    public void testAddTask(String taskName) {
        HomePage homePage = new HomePage(getDriver());
        homePage.addTask(taskName);
        Assert.assertTrue(homePage.isTaskPresent(taskName), "The task has not been added!");
    }

    @Test
    public void testDeleteTask(String taskName) {
        HomePage homePage = new HomePage(getDriver());
        homePage.taskDelete();
        Assert.assertFalse(homePage.isTaskPresent(taskName), "The task has not been deleted!");
    }

    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(getDriver());
        homePage.logoOutMethod();
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.ContinueWithEmailButton.isElementPresent());
    }
    @Test
    public void testRemoveAccount(String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.removeAccountMethod(password);
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

   /* @Test
    public void testAddMultipleTasks() {
        HomePage homePage = new HomePage(getDriver());
        homePage.addTask("Task 1");
        homePage.addTask("Task2");
        Assert.assertTrue(homePage.isTaskPresent("Task 1"), "The first task has not been added!");
        Assert.assertTrue(homePage.isTaskPresent("Task 2"), "The first task has not been added");
    }

    @Test
    public void testLongPressTask() {
        HomePage homePage = new HomePage(getDriver());
        homePage.longPress("//android.widget.TextView[@text='Task 1']");
        Assert.assertTrue(homePage.isElementPresent("//android.widget.Button[@text='Edit']"),
                "The edit menu did not appear!");
    }*/
}
