package com.jsystems.Frontend.tests;

import com.jsystems.Frontend.FrontendConfigFactory;
import com.jsystems.Frontend.TestDataStatic;
import com.jsystems.Frontend.page.LoginPage;
import com.jsystems.Frontend.page.MainLoginPage;
import com.jsystems.Frontend.page.MainPage;
import com.jsystems.Frontend.page.PasswordPage;
import org.junit.Ignore;
import org.junit.Test;

public class LoginTest extends FrontendConfigFactory {
    MainPage mainPage;
    PasswordPage passwordPage;
    MainLoginPage mainLoginPage;

    @Test
    @Ignore
    public void testContentMain(){
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
        mainPage.isContentPresent();
    }

    @Test
    @Ignore
    public void testContentLogin(){
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
        mainPage.logIn.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isContentPresent();
    }

    @Test
    @Ignore
    public void testContentPassword() throws InterruptedException {
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
        mainPage.logIn.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInput.sendKeys(TestDataStatic.login);
        loginPage.buttonContinue.click();
        Thread.sleep(2000);
        passwordPage = new PasswordPage(driver);
        passwordPage.isContentPage();
    }

    @Test
    @Ignore
    public void testLogin(){
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
        mainPage.logIn.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInput.sendKeys(TestDataStatic.login);
        loginPage.buttonContinue.click();
        passwordPage = new PasswordPage(driver);
        passwordPage.passwordInput.sendKeys(TestDataStatic.password);
        passwordPage.buttonLogIn.click();
        mainLoginPage = new MainLoginPage(driver);
        mainLoginPage.isContentPresent();
    }
}
