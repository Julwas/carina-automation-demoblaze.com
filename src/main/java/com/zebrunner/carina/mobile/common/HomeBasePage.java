package com.zebrunner.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomeBasePage extends AbstractPage {
    public HomeBasePage(WebDriver driver) {
        super(driver);
    }
    public abstract void addTask(String taskName);
    public abstract boolean isAddTaskButtonPresent();
    public abstract boolean isListOfTaskPresent();

    public abstract boolean isTaskPresent(String taskName);

    public abstract void taskDelete();

    public abstract void toDayShow();

    public abstract void logoOutMethod();
}
