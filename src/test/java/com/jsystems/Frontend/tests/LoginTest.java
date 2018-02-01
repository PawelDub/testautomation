package com.jsystems.Frontend.tests;

import com.jsystems.Frontend.FrontendConfigFactory;
import com.jsystems.Frontend.TestDataStatic;
import com.jsystems.Frontend.page.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
//import org.junit.jupiter.api.DisplayName;

//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;

//@RunWith(JUnitPlatform.class)
public class LoginTest extends FrontendConfigFactory {
    MainPage mainPage;
    PasswordPage passwordPage;
    MainLoginPage mainLoginPage;
    PersonalPage personalPage;
    NotificationPage notificationPage;

    @Test
//    @Ignore
    public void testContentMain(){
//        driver.get(baseUrl);
        mainPage = new MainPage(driver);
        mainPage.isContentPresent();
    }

    @Test
//    @Ignore
    public void testContentLogin(){
//        driver.get(baseUrl);
        mainPage = new MainPage(driver);
        mainPage.logIn.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isContentPresent();
    }

    @Test
//    @Ignore
    public void testContentPassword() throws InterruptedException {
//        driver.get(baseUrl);
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
//    @Ignore
    public void testLogin(){
//        driver.get(baseUrl);
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

    @Test
    public void insertTextTest(){
        mainPage = new MainPage(driver);
        mainPage.logIn.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInput.sendKeys(TestDataStatic.login);
        loginPage.buttonContinue.click();
        passwordPage = new PasswordPage(driver);
        passwordPage.passwordInput.sendKeys(TestDataStatic.password);
        passwordPage.buttonLogIn.click();
        mainLoginPage = new MainLoginPage(driver);
        mainLoginPage.webWait(mainLoginPage.avatar, 15);
        mainLoginPage.avatar.click();
        personalPage = new PersonalPage(driver);

        assertFalse(personalPage.profileDetailsSave.isEnabled());
        personalPage.textArea.clear();
        personalPage.textArea.sendKeys("To jest moj profile");
        personalPage.webWait(personalPage.profileDetailsSave, 10);
        assertTrue(personalPage.textArea.getText().equals("To jest moj profile"));
    }


    @Test
    public void notificationTest(){
        mainPage = new MainPage(driver);
        mainPage.logIn.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInput.sendKeys(TestDataStatic.login);
        loginPage.buttonContinue.click();
        passwordPage = new PasswordPage(driver);
        passwordPage.passwordInput.sendKeys(TestDataStatic.password);
        passwordPage.buttonLogIn.click();
        mainLoginPage = new MainLoginPage(driver);
        mainLoginPage.avatar.click();
        personalPage = new PersonalPage(driver);

        personalPage.notificationList.click();
        notificationPage = new NotificationPage(driver);
        assertTrue(notificationPage.firstCheckboc.isSelected());
        notificationPage.firstCheckboc.click();
        assertFalse(notificationPage.firstCheckboc.isSelected());
        notificationPage.firstCheckboc.click();
        assertTrue(notificationPage.firstCheckboc.isSelected());

    }
}
