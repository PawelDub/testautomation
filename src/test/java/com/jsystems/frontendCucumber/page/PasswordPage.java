package com.jsystems.frontendCucumber.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class PasswordPage extends HelperPage {
    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    public WebElement passwordInput = driver.findElement(By.id("password"));

    public WebElement buttonLogIn = driver.findElement(By.cssSelector("div.login__form-action button.button.form-button.is-primary"));


    public boolean isContentPage(){
        assertTrue(passwordInput.isDisplayed());
        assertTrue(buttonLogIn.isDisplayed());
        assertTrue(buttonLogIn.getText().equals(TestDataStatic.logIn));
        assertTrue(buttonLogIn.isEnabled());
        return true;
    }
}
