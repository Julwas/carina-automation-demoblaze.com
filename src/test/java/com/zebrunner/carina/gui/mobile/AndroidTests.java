package com.zebrunner.carina.gui.mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.mobile.HomePage;
import com.zebrunner.carina.mobile.LoginPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

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

    @Test
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

    /*@Test
    public void testLogout() {
        HomePage homePage = new HomePage(getDriver());
        homePage.click("//android.widget.Button[@text='Settings']");
        homePage.click("//android.widget.Button[@text='Log out']");
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isElementPresent("//android.widget.Button[@text='Log in']"), "Выход не выполнен!");
    }

    @Test
    public void testAppRestart() {
        getDriver().quit();
        getDriver().launchApp();
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isElementPresent("//android.widget.Button[@content-desc='Add Task']"),
                "Приложение не перезапустилось корректно!");
    }

    @Test
    public void testHomeScreenVisible() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isElementPresent("//android.widget.Button[@content-desc='Add Task']"),
                "Главный экран не отображается!");
    }

    @Test
    public void testCheckTaskList() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isElementPresent("//android.widget.ListView"), "Список задач отсутствует!");
    }

    @Test
    public void testAddMultipleTasks() {
        HomePage homePage = new HomePage(getDriver());
        homePage.addTask("Задача 1");
        homePage.addTask("Задача 2");
        Assert.assertTrue(homePage.isTaskPresent("Задача 1"), "Первая задача не добавлена!");
        Assert.assertTrue(homePage.isTaskPresent("Задача 2"), "Вторая задача не добавлена!");
    }

    @Test
    public void testLongPressTask() {
        HomePage homePage = new HomePage(getDriver());
        homePage.longPress("//android.widget.TextView[@text='Задача 1']");
        Assert.assertTrue(homePage.isElementPresent("//android.widget.Button[@text='Edit']"),
                "Меню редактирования не появилось!");
    }*/
}
