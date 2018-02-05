package com.jsystems.frontendCucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class NotificationPage extends HelperPage {
    public NotificationPage(WebDriver driver) {
        super(driver);
    }
    public WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"primary\"]/main/div[3]/div/div[1]/div[2]/div[3]/ul/li[2]/input"));


    public boolean isContentPresent(){

        assertTrue(checkbox.isDisplayed());
        assertTrue(checkbox.isSelected());
        return true;
    }
}
