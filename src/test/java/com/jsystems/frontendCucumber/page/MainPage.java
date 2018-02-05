package com.jsystems.frontendCucumber.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class MainPage extends HelperPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String title = driver.getTitle();

    public WebElement logIn = driver.findElement(By.id("navbar-login-link"));

    public WebElement wordpress29percentage = driver.findElement(By.cssSelector("section#hero div.hp-hero__wrapper h1 span"));

    public WebElement getStartedBig = driver.findElement(By.id("hero-cta"));



    public boolean isContentPresent(){
        assertTrue(title.equals(TestDataStatic.wordpressTitle));
        assertTrue(wordpress29percentage.getText().equals(TestDataStatic.wordPressPower));
        assertTrue(logIn.getText().equals(TestDataStatic.logIn));
        assertTrue(getStartedBig.isDisplayed());
        assertTrue(getStartedBig.isEnabled());
        return true;
    }

}
