package com.jsystems.frontend.tests;

import com.jsystems.frontend.FrontendConfigFactory;
import com.jsystems.frontend.TestDataStatic;
import com.jsystems.frontend.page.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LoginTest extends FrontendConfigFactory {
    MainPage mainPage;
    PasswordPage passwordPage;
    MainLoginPage mainLoginPage;
    PersonalPage personalPage;
    NotificationPage notificationPage;


    // Pamiętajmy aby @Nested było importowane z paczki JUpiter
    @Nested
    @DisplayName("==Testy contentu stron")
    public class ContentTest {

        @Test
//    @Ignore  // w przypadku uruchamiania testów przez JUnit
//    @Disabled  // w przypadku uruchamiania testów przez JUpiter
        @DisplayName("=== Sprawdzenie contentu strony ===")
        public void testContentMain() {

            // wywołanie baseUri zostało przeniesione do setUp() FrontendConfigFactory
//        driver.get(baseUrl);
            mainPage = new MainPage(driver);
            mainPage.isContentPresent();
        }

        @Test
//    @Ignore
        public void testContentLogin() {
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


    }

    @Nested
    @DisplayName("== Testy Logowania")
    public class LoginNestedTest {

        @Test
//    @Ignore
        public void testLogin() {
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
    }

    @Nested
    @DisplayName("= MainPersonalPage Testy")
    public class MainPersonalPage {

        @Test
        public void insertTextTest() {
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
    }

    @Nested
    @DisplayName("==NotificationPage Test")
    public class NotificationPageTest {

        @Test
        public void notificationTest() {
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
}
