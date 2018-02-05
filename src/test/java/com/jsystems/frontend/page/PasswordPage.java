package com.jsystems.frontend.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class PasswordPage extends BasePage {
    WebDriver driver;
    public PasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = "div.login__form-action button.button.form-button.is-primary")
    public WebElement buttonLogIn;


    public boolean isContentPage(){
        assertTrue(passwordInput.isDisplayed());
        assertTrue(buttonLogIn.isDisplayed());
        assertTrue(buttonLogIn.getText().equals(TestDataStatic.logIn));
        assertTrue(buttonLogIn.isEnabled());
        return true;
    }
}
