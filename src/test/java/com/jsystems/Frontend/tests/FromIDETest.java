package com.jsystems.Frontend.tests;

import java.util.concurrent.TimeUnit;

import com.jsystems.Frontend.FrontendConfigFactory;
import com.jsystems.Frontend.page.LoginPage;
import com.jsystems.Frontend.page.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static com.jsystems.Frontend.TestDataStatic.logIn;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


public class FromIDETest extends FrontendConfigFactory {

    public FromIDETest() {
    }

    @Test
//    @Ignore
    public void testUntitledTestCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("navbar-login-link")).click();
        driver.findElement(By.id("usernameOrEmail")).clear();
        driver.findElement(By.id("usernameOrEmail")).sendKeys("automation012018@wp.pl");
        driver.findElement(By.cssSelector("button.button.form-button.is-primary")).click();
//            driver.findElement(By.id("passwordInput")).clear();
        driver.findElement(By.id("passwordInput")).sendKeys("Bimbajlo1@");
        driver.findElement(By.cssSelector("button.button.form-button.is-primary")).click();
        driver.findElement(By.cssSelector("img.gravatar")).click();
        driver.findElement(By.xpath("//div[@id='secondary']/ul/li/ul/li[5]/a/span")).click();
        driver.findElement(By.xpath("(//input[@value='on'])[8]")).click();
        driver.findElement(By.cssSelector("button.button.form-button.is-primary")).click();
        driver.findElement(By.cssSelector("span.notice__dismiss > svg.gridicon.gridicons-cross")).click();
    }




}
