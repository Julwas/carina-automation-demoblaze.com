package com.zebrunner.carina.mobile.android;

import com.zebrunner.carina.mobile.common.HomeBasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomeBasePage {

    @FindBy(id = "com.todoist:id/fab")
    private ExtendedWebElement addTaskButton;

    @FindBy(id = "android:id/message")
    private ExtendedWebElement taskNameField;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement saveTaskButton;

    @FindBy(id = "android:id/button/remove")
    private ExtendedWebElement removeTaskButton;

    @FindBy(xpath = "//*[@resource-id=\"test_tag_navigation\"]/*[1]")
    private ExtendedWebElement browseButton;

    @FindBy(xpath = "//*[@resource-id=\"test_tag_navigation\"]/*[1]")
    private ExtendedWebElement settingsButton;

    @FindBy(xpath = "//android.widget.Button[@text='Log out']")
    private ExtendedWebElement logOutButton;

    @FindBy(xpath = "(//*[@resource-id=\"android:id/icon\"])[2]")
    private ExtendedWebElement accountButton;

    @FindBy(xpath = "(//*[@resource-id=\"android:id/icon\"])[2]")
    private ExtendedWebElement toDayButton;

    @FindBy(xpath = "//*[@resource-id='androidx:id/content_scrim_container']/*")
    private ExtendedWebElement listOfTasks;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement deleteButton;

    @FindBy(id = "android:id/edit")
    private ExtendedWebElement passwordConfirmField;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement deleteForeverButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addTask(String taskName) {
        addTaskButton.click();
        taskNameField.type(taskName);
        saveTaskButton.click();
    }


    public boolean isAddTaskButtonPresent() {
        return addTaskButton.isElementPresent();
    }

    public boolean isListOfTaskPresent() {
        return listOfTasks.isElementPresent();
    }

    public boolean isTaskPresent(String taskName) {
        try {
            return driver.findElement
                    (By.xpath("//android.widget.TextView[@text='" + taskName + "']")) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void taskDelete() {
        removeTaskButton.click();
    }

    public void toDayShow() {
        toDayButton.click();
    }

    public void logoOutMethod() {
        browseButton.click();
        settingsButton.click();
        logOutButton.click();
    }
}
