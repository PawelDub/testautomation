
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.fail;


public class TestFromIDE {
//        private WebDriver driver;
//        private String baseUrl;
//        private boolean acceptNextAlert = true;
//        private StringBuffer verificationErrors = new StringBuffer();
//
//        @Before
//        public void setUp() throws Exception {
////            System.setProperty("webdriver.chrome.driver", "web-drivers/chromedriver.exe");
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--start-maximized");
//            driver = new ChromeDriver(chromeOptions);
//            baseUrl = "https://www.katalon.com/";
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        }
//
//        @Test
//        public void testUntitledTestCase() throws Exception {
//            driver.get("https://wordpress.com/");
//            driver.findElement(By.id("navbar-login-link")).click();
//            driver.findElement(By.id("usernameOrEmail")).clear();
//            driver.findElement(By.id("usernameOrEmail")).sendKeys("automation012018@wp.pl");
//            driver.findElement(By.cssSelector("button.button.form-button.is-primary")).click();
////            driver.findElement(By.id("password")).clear();
//            driver.findElement(By.id("password")).sendKeys("Bimbajlo1@");
//            driver.findElement(By.cssSelector("button.button.form-button.is-primary")).click();
//            driver.findElement(By.cssSelector("img.gravatar")).click();
//            driver.findElement(By.xpath("//div[@id='secondary']/ul/li/ul/li[5]/a/span")).click();
//            driver.findElement(By.xpath("(//input[@value='on'])[8]")).click();
//            driver.findElement(By.cssSelector("button.button.form-button.is-primary")).click();
//            driver.findElement(By.cssSelector("span.notice__dismiss > svg.gridicon.gridicons-cross")).click();
//        }
//
//        @After
//        public void tearDown() throws Exception {
//            driver.quit();
//            String verificationErrorString = verificationErrors.toString();
//            if (!"".equals(verificationErrorString)) {
//                fail(verificationErrorString);
//            }
//        }
//
//        private boolean isElementPresent(By by) {
//            try {
//                driver.findElement(by);
//                return true;
//            } catch (NoSuchElementException e) {
//                return false;
//            }
//        }
//
//        private boolean isAlertPresent() {
//            try {
//                driver.switchTo().alert();
//                return true;
//            } catch (NoAlertPresentException e) {
//                return false;
//            }
//        }
//
//        private String closeAlertAndGetItsText() {
//            try {
//                Alert alert = driver.switchTo().alert();
//                String alertText = alert.getText();
//                if (acceptNextAlert) {
//                    alert.accept();
//                } else {
//                    alert.dismiss();
//                }
//                return alertText;
//            } finally {
//                acceptNextAlert = true;
//            }
//        }

}
