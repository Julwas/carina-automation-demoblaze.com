package com.zebrunner.carina.mobile;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "com.todoist:id/fab")
    private ExtendedWebElement addTaskButton;
// xpath= "//android.widget.ImageButton[@content-desc="Quick add"]"
    @FindBy(id = "android:id/message")
    private ExtendedWebElement taskNameField;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement saveTaskButton;
@FindBy(id = "dd")
    private ExtendedWebElement taskButton;

    // ="//android.widget.ImageView[@content-desc="Add"]"
   /* @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/content_scrim_container\"]/android.view.View")
private ExtendedWebElement backCklickElement;*/

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
    public boolean isTaskPresent(String taskName) {
        try {
            return driver.findElement(By.xpath("//android.widget.TextView[@text='" + taskName + "']")) != null;
        } catch (Exception e) {
            return false;  // Если задача не найдена, возвращаем false
        }
    }

public void taskDelete(){
    taskButton.click();
}
}
