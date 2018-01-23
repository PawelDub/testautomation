package com.jsystems.FrontendCucumber.page;

import com.jsystems.Frontend.TestDataStatic;
import com.jsystems.Frontend.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;


public class LoginPage extends HelperPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement loginHeader = driver.findElement(By.cssSelector("div#primary div.login__form-header")) ;

    public WebElement usernameInput = driver.findElement(By.id("usernameOrEmail"));

    public WebElement buttonContinue = driver.findElement(By.cssSelector("div.login__form-action button[type=\"submit\"]"));


    public boolean isContentPresent(){
        assertTrue(loginHeader.getText().equals(TestDataStatic.loginHeader));
        assertTrue(usernameInput.isDisplayed());
        assertTrue(buttonContinue.getText().equals(TestDataStatic.continueButton));
        assertTrue(buttonContinue.isDisplayed());
        assertTrue(buttonContinue.isEnabled());
        return true;
    }
}
