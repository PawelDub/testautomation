package com.jsystems.frontend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    // Jeżeli testy uruchamiane są przez JUnit to używamy metody @BeforeClass
    // Jeżeli testy są uruchamiane przez JUpiter to używamy @BeForeAll
//    @BeforeClass
    @BeforeAll
    public static void setupClass() {
        System.out.println("================== @BeforeClass Frontend =====================");
        WebDriverManager.chromedriver().setup();
    }


    // Jeżeli testy uruchamiane są przez JUnit to używamy metody @Before
    // Jeżeli testy są uruchamiane przez JUpiter to używamy @BeForeEach
//    @Before
    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("================== @Before Frontend JUnit =====================");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        baseUrl = "https://wordpress.com/";
        if (driver == null) {
            driver = new ChromeDriver(chromeOptions);
        }
        pripareDriver();
        driver.get(baseUrl);
    }

    void pripareDriver(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Jeżeli testy uruchamiane są przez JUnit to używamy metody @After
    // Jeżeli testy są uruchamiane przez JUpiter to używamy @AfterEach
//    @After
    @AfterEach
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
