package com.jsystems.frontend.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class MainPage extends BasePage {
//    WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String title = driver.getTitle();

    @FindBy(css = "body")
    public WebElement body;

    @FindBy(css = ".hp-hero-title.no-widows span:nth-Child(2)")
    public WebElement wordpress29percentage;
//    public WebElement wordpress29percentage = driver.findElement(By.cssSelector(".hp-hero-title.no-widows span:nth-Child(2)"));

    @FindBy(css = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in a")
    public WebElement logIn;
//        public WebElement logIn = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in a"));


    @FindBy(id = "hero-cta")
    public WebElement getStartedBig;
//    public WebElement getStartedBig = driver.findElement(By.id("hero-cta"));

    //    @Override
    public boolean isContentPresent() {
        assertTrue(driver.getTitle().equals(TestDataStatic.wordpressTitle));
//        assertTrue(wordpress29percentage.getText().equals(TestDataStatic.wordPressPower));
        assertTrue(logIn.getText().equals(TestDataStatic.logIn));
//        assertTrue(getStartedBig.isDisplayed());
        assertTrue(getStartedBig.isEnabled());
        return true;
    }
}
