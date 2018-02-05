package com.jsystems.frontend.tests;

import com.jsystems.frontend.FrontendConfigFactory;
import com.jsystems.frontend.TestDataStatic;
import com.jsystems.frontend.page.LoginPage;
import com.jsystems.frontend.page.MainPage;
import com.jsystems.frontend.page.PasswordPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

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

//    @Test
//    public void editCell() throws InterruptedException {
//        String browserName = System.getProperty("org.qooxdoo.demo.browsername");
//        String browserVersion = System.getProperty("org.qooxdoo.demo.browserversion");
//        boolean condition = browserName.contains("internet") && browserVersion.equals("8");
//        org.junit.Assume.assumeTrue(!condition);
//        String cellXpath = "div[contains(@class, 'qooxdoo-table-cell') and position() = 3]";
//        String newText = "Hello WebDriver!";
//
//        // Scroll to row #12 and select cell #3
//        WebElement row = table.scrollToRow(12);
//        WebElement dateCell = row.findElement(By.xpath(cellXpath));
//        dateCell.click();
//
//        // Double click cell #3 to activate edit mode
//        Actions builder = new Actions(driver);
//        builder.doubleClick(dateCell).perform();
//
//        Widget editor = table.getCellEditor();
//        String old = (String) editor.getPropertyValue("value");
//
//        // Clear old content
//        Actions keyBuilder = new Actions(driver.getWebDriver())
//                .sendKeys(Keys.END);
//        for (int i = 0; i < old.length(); i++) {
//            keyBuilder.sendKeys(Keys.BACK_SPACE);
//        }
//        keyBuilder.perform();
//
//        // Type new cell content
//        editor.sendKeys(newText);
//        editor.sendKeys(Keys.RETURN);
//
//        // update the cell element and check the new content
//        row = table.scrollToRow(12);
//        dateCell = row.findElement(By.xpath(cellXpath));
//        Assert.assertEquals(newText,  dateCell.getText());
//    }

}
