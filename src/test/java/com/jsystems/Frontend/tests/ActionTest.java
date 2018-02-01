package com.jsystems.Frontend.tests;

import com.jsystems.Frontend.FrontendConfigFactory;
import com.jsystems.Frontend.page.MainPage;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.sql.DriverManager.getDriver;

public class ActionTest extends FrontendConfigFactory {

    MainPage mainPage;

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
