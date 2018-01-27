package com.jsystems.Frontend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class FrontendConfigFactory {

    public WebDriver driver = null;
    public String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public String id = "0";

    @BeforeClass
    public static void setupClass() {
        System.out.println("================== @BeforeClass Frontend =====================");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("================== @Before Frontend JUnit =====================");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        baseUrl = "https://wordpress.com/";
        if (driver == null) {
            driver = new ChromeDriver(chromeOptions);
        }
        pripareDriver();
    }

    void pripareDriver(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("================== @After Frontend =====================");
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        driver.quit();
        driver = null;
        }
        driver.close();
    }

}
