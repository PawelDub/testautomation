package com.jsystems.frontendCucumber.steps;

import com.jsystems.frontend.TestDataStatic;
import com.jsystems.frontendCucumber.FrontendCucumberFactory;
import com.jsystems.frontendCucumber.page.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WordpressSteps extends HelperSteps {

    //Jeżeli nie robilibysmy dziedziczenia po klasie HelperSteps to musielibysmy wówczas mieć tutaj pole
    // WebDriver driver;
    // oraz w konstruktorze nie możemy wówczas mieć linii
    // super(CONFIG) wymuszone to jest ze względu na dziedziczenie

    public WordpressSteps(FrontendCucumberFactory config) {

        super(config);
        try {
            driver = config.setUp();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(config.id);
        }
    }

    MainPage mainPage;
    LoginPage loginPage;
    PasswordPage passwordPage;
    MainLoginPage mainLoginPage;
    PersonalPage personalPage;
    NotificationPage notificationPage;

    @Given("^User is on wordpress website \"(.*)\"$")
    public void userIsOnWordpressWebsite(String website) {
        driver.get(website);

        mainPage = new MainPage(driver);
//        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(mainPage.logIn));

        assertTrue(mainPage.title.equals(TestDataStatic.wordpressTitle));
    }

    @When("^User clicks to login$")
    public void userClicksToLogin() {
        mainPage.logIn.click();
    }

    @Then("^User is on first login page$")
    public void userIsOnFirstLoginPage() {
        loginPage = new LoginPage(driver);
        assertTrue(loginPage.loginHeader.isDisplayed());
    }

    @When("^User enter email and press Continue$")
    public void userEnterEmailAndPressContinue() {
        loginPage.usernameInput.sendKeys(TestDataStatic.login);
        loginPage.buttonContinue.click();
    }

    @Then("^User is on second page password$")
    public void userIsOnSecondPagePassword() {
        passwordPage = new PasswordPage(driver);
        assertTrue(passwordPage.buttonLogIn.isDisplayed());
    }

    @When("^User enter password and press LogIn$")
    public void userEnterPasswordAndPressLogIn() {
        passwordPage.passwordInput.sendKeys(TestDataStatic.password);
        passwordPage.buttonLogIn.click();
    }

    @Then("^User is on main login page$")
    public void userIsOnMainLoginPage() throws Throwable {
        mainLoginPage = new MainLoginPage(driver);
        Thread.sleep(3000);
        assertTrue(mainLoginPage.avatar.isDisplayed());
    }

    @When("^User press avatar$")
    public void userPressAvatar() {
        mainLoginPage.avatar.click();
    }

    @Then("^User is personal page$")
    public void userIsPersonalPage() {
        personalPage = new PersonalPage(driver);
        assertTrue(personalPage.titleNotification.isDisplayed());
        personalPage.notification.click();
    }

    @When("^User is click notification$")
    public void userIsOnNotificationPage() {
        notificationPage = new NotificationPage(driver);
        notificationPage.isContentPresent();
        notificationPage.checkbox.isDisplayed();
        notificationPage.checkbox.isSelected();
    }

    @Then("^User press checkbox$")
    public void userPressCheckbox() {
        notificationPage.checkbox.click();
    }

    @When("^Checkbox is unselected$")
    public void checkboxIsUnselected() {
        assertFalse(notificationPage.checkbox.isSelected());
        notificationPage.checkbox.click();
    }
}