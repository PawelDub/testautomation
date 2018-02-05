package com.jsystems.frontend.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class MainLoginPage extends BasePage {
    WebDriver driver;

    public MainLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[data-tip-target=\"me\"]")
    public WebElement avatar;

    @FindBy(css = "a[data-tip-target=\"my-sites\"] span")
    public WebElement mySite;


    public boolean isContentPresent(){
        assertTrue(avatar.isDisplayed());
        assertTrue(mySite.isDisplayed());
        assertTrue(mySite.getText().equals(TestDataStatic.mySite));
        return true;
    }
}

