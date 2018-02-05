package com.jsystems.frontend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class BasePage {
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

    public void webWait(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void webWaitByTime(Long time){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
    }

    public UUID randomTitle() {
        UUID temp = UUID.randomUUID();
        return temp;
    }
}
