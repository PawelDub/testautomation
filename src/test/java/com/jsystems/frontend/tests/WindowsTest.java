package com.jsystems.frontend.tests;

import com.jsystems.frontend.FrontendConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WindowsTest  extends FrontendConfigFactory {

    @Test
    public void testWindows(){
        String firstPageWindowHandle;
        String secondTestWindowHandle = null;
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

        firstPageWindowHandle = driver.getWindowHandle();

        int hyperlinkYCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getY();
        int hyperlinkXCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getX();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in a new window")));

        driver.findElement(By.linkText("Open page in a new window")).click();

        Set<String> testPageWindowHandle = driver.getWindowHandles();

        for (String windowHandle : testPageWindowHandle) {
            if (!firstPageWindowHandle.equals(windowHandle)) {
                secondTestWindowHandle = windowHandle;
            }
        }
        driver.switchTo().window(secondTestWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        driver.switchTo().window(secondTestWindowHandle).close();

        driver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

//        driver.close();
    }

    @Test
    public void frameTest(){
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("testframe")));

        WebElement testframe = driver.findElement(By.name("testframe"));

        driver.switchTo().frame(testframe);

        String expectedFrameText =driver.findElement(By.id("testpagelink")).getText();
        String actualFrameText = "My frame text";

        if(actualFrameText.equals(expectedFrameText)){
            System.out.println("Found my frame text");
        }
        else {
            System.out.println("Did not find my frame text");
        }

        driver.switchTo().parentFrame();
    }


    @Test
    public void pageScroll() {
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

//wait until Selenium can find the link with locator Linktext "Open page in a new window" on the test page.

        (new WebDriverWait(driver, 10))

                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in the same window")));


//Point Selenium to the Element you want to scroll to and get it's Location

//Store location with Y coordinates in the variable hyperlinkYCoordinate of type integer

        int hyperlinkYCoordinate = driver.findElement(By.linkText("Open page in the same window")).getLocation().getY();


//Store location with X coordinates in the variable hyperlinkYCoordinate of type integer

        int hyperlinkXCoordinate = driver.findElement(By.linkText("Open page in the same window")).getLocation().getX();


// Use Java Script Executor to scroll down the WebPage to the position where the element is

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;


// parse the X and Y coordinates from the above into the execute Script method with the following String

        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

// wait until element 'linkText("Open page in the same window")' is clickable
        (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in the same window")));

// click on the link

        driver.findElement(By.linkText("Open page in the same window")).click();

//        driver.close();


    }

    @Test
    public void popupHandler(){
        driver.switchTo().alert();
//Selenium-WebDriver Java Code for entering Username & Password as below:
        driver.findElement(By.id("userID")).sendKeys("userName");
        driver.findElement(By.id("password")).sendKeys("myPassword");
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

}
