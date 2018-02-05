package com.jsystems.frontendCucumber.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;


public class LoginPage extends HelperPage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "div#primary div.login__form-header")
    public WebElement loginHeader;
//    public WebElement loginHeader = driver.findElement(By.cssSelector("div#primary div.login__form-header")) ;

    @FindBy(id = "usernameOrEmail")
    public WebElement usernameInput;
//    public WebElement usernameInput = driver.findElement(By.id("usernameOrEmail"));

    @FindBy(css = "div.login__form-action button[type=\"submit\"]")
    public WebElement buttonContinue;
//    public WebElement buttonContinue = driver.findElement(By.cssSelector("div.login__form-action button[type=\"submit\"]"));


    public boolean isContentPresent(){
        assertTrue(loginHeader.getText().equals(TestDataStatic.loginHeader));
        assertTrue(usernameInput.isDisplayed());
        assertTrue(buttonContinue.getText().equals(TestDataStatic.continueButton));
        assertTrue(buttonContinue.isDisplayed());
        assertTrue(buttonContinue.isEnabled());
        return true;
    }
}
