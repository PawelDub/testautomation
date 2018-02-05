package com.jsystems.frontend.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPage extends BasePage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "navbar-login-link")
    public WebElement logIn;

    @FindBy(css = "section#hero div.hp-hero__wrapper h1 span")
    public WebElement wordpress29percentage;


    @FindBy(id = "hero-cta")
    public WebElement getStartedBig;


    public boolean isContentPresent(){
       assertTrue(driver.getTitle().equals(TestDataStatic.wordpressTitle));
        assertTrue(wordpress29percentage.getText().equals(TestDataStatic.wordPressPower));
        assertTrue(logIn.getText().equals(TestDataStatic.logIn));
        assertTrue(getStartedBig.isDisplayed());
        assertTrue(getStartedBig.isEnabled());
       return true;
    }
}
