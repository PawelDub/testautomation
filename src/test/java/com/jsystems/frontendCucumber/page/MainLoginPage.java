package com.jsystems.frontendCucumber.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class MainLoginPage extends HelperPage {

    public MainLoginPage(WebDriver driver) {
        super(driver);
    }
    public WebElement avatar = driver.findElement(By.cssSelector("a[data-tip-target=\"me\"]"));

    public WebElement mySite = driver.findElement(By.cssSelector("a[data-tip-target=\"my-sites\"] span"));


    public boolean isContentPresent(){
        assertTrue(avatar.isDisplayed());
        assertTrue(mySite.isDisplayed());
        assertTrue(mySite.getText().equals(TestDataStatic.mySite));
        return true;
    }
}

