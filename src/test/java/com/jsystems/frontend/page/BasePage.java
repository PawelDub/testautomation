package com.jsystems.frontend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class BasePage implements BasePageInterface {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertTekst(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void waitForVisibilityOfElement(WebElement element, int maxWaitTime){
        WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitMaxTime(Long time){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openBaseUrl(String baseUrl) {
        driver.get(baseUrl);
    }

    public UUID randomUUID() {
        UUID temp = UUID.randomUUID();
        return temp;
    }

    @Override
    public boolean isContentPresent() {
        return false;
    }
}
