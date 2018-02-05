package com.jsystems.frontendCucumber.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class PersonalPage extends HelperPage {

    public PersonalPage(WebDriver driver) {
        super(driver);
    }
    public WebElement titleNotification = driver.findElement(By.className("profile-gravatar__user-display-name"));

    public WebElement notification = driver.findElement(By.cssSelector("a[href=\"/me/notifications\"]"));


    public boolean isContentPresent(){
        assertTrue(titleNotification.isDisplayed());
        assertTrue(notification.isDisplayed());
        assertTrue(notification.getText().equals(TestDataStatic.notification));
        return true;
    }
}

