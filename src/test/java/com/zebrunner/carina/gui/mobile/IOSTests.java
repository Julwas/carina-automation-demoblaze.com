package com.zebrunner.carina.gui.mobile;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

/*public class IOSTests implements IAbstractTest, IMobileUtils {

    @Test
    public void testLoginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logInWithEmail();
        loginPage.login("test@example.com", "wrongpassword");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "There is no error message!");
    }

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logInWithEmail();
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
        homePage.deleteTask("Task1");
        Assert.assertFalse(homePage.isTaskPresent("Task1"), "The task has not been deleted!");
    }

    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(getDriver());
        homePage.logout();
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isContinueWithEmailButtonPresent(),
                "Logout failed! The 'Continue with Email' button is not visible.");
    }

    @Test
    public void testHomeScreenVisible() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isAddTaskButtonPresent(), "The home screen is not displayed!");
    }

    @Test
    public void testCheckTaskList() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openTodayTasks();
        Assert.assertTrue(homePage.isListOfTasksPresent(), "There is no task list!");
    }

    @Test
    public void testAddMultipleTasks() {
        HomePage homePage = new HomePage(getDriver());
        homePage.addTask("Task2");
        homePage.addTask("Task3");
        Assert.assertTrue(homePage.isTaskPresent("Task2"), "The first task has not been added!");
        Assert.assertTrue(homePage.isTaskPresent("Task3"), "The second task has not been added!");
    }

    @Test
    public void testAppRestart() {
        getDriver().quit();
        getDriver();
        ((IOSDriver) getDriver()).activateApp("com.todoist.ios");
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isContinueWithEmailButtonPresent(),
                "The application did not restart correctly!");
    }
}*/
