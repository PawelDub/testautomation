package com.jsystems.frontend.tests;

import com.jsystems.frontend.FrontendConfigFactory;
import com.jsystems.frontend.TestDataStatic;
import com.jsystems.frontend.page.LoginPage;
import com.jsystems.frontend.page.MainPage;
import com.jsystems.frontend.page.PasswordPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static java.sql.DriverManager.registerDriver;

public class ActionTest extends FrontendConfigFactory {

    MainPage mainPage;
    LoginPage loginPage;
    PasswordPage passwordPage;

    @Test
    public void actionTest() {

        driver.get(baseUrl);
        mainPage = new MainPage(driver);
//        mainPage.logIn.click();
        Actions action = new Actions(driver);
        action.moveToElement(
                mainPage.logIn,
                5, 5);
//        action.clickAndHold();
//        action.moveByOffset(xOffset, yOffset);
//        action.release();
        action.build().perform();
    }

    @Test
    public void actionNextTest() {

        driver.get(baseUrl);
        mainPage = new MainPage(driver);
        mainPage.logIn.click();
        loginPage = new LoginPage(driver);

        // akcje możemy budować wielo-etapowe
        Actions action = new Actions(driver);
        action.moveToElement(loginPage.usernameInput)
                .sendKeys(TestDataStatic.login)
                .moveToElement(loginPage.buttonContinue)
                // jak po . klikniecie Ctrl + space to rozwinie wam się lista dostępnych metod z klasy Actions
                .click()
                .build().perform();

        passwordPage = new PasswordPage(driver);
        passwordPage.webWait(passwordPage.passwordInput, 15);
        passwordPage.isContentPage();
    }


    @Test
    public void testBasicRInteraction() {
        Actions do42 = new Actions(driver);
        do42.sendKeys(Keys.chord(Keys.CONTROL, "l"));
        do42.sendKeys(Keys.ESCAPE);
        do42.sendKeys("41 + 1");
        do42.sendKeys(Keys.ENTER);
        do42.perform();

    }


}
