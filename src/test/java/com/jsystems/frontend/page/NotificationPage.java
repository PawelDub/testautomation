package com.jsystems.frontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class NotificationPage extends BasePage {

    WebDriver driver;

    public NotificationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"primary\"]/main/div[3]/div/div[1]/div[2]/div[2]/ul/li[1]/input")
    public WebElement firstCheckbox;

    @Override
    public boolean isContentPresent() {
        assertTrue(firstCheckbox.isDisplayed());
        return true;
    }
}