package com.zebrunner.carina.gui.components;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class AlertHandler {
    private WebDriver driver;

    public AlertHandler(WebDriver driver) {
        this.driver = driver;
    }

    public void handleAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }
    }

}
