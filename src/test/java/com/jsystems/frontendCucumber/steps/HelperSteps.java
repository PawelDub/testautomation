package com.jsystems.frontendCucumber.steps;

import com.jsystems.frontendCucumber.FrontendCucumberFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperSteps {
    WebDriver driver;

    public HelperSteps(FrontendCucumberFactory config) {
        try {
            driver = config.setUp();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(config.id);
        }
    }

    public void webWait(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
