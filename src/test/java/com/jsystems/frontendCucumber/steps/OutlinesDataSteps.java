package com.jsystems.frontendCucumber.steps;

import com.jsystems.frontendCucumber.FrontendCucumberFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OutlinesDataSteps extends HelperSteps {
    WebDriver driver;

    public OutlinesDataSteps(FrontendCucumberFactory config) {
        super(config);
        try {
            driver = config.setUp();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(config.id);
        }
    }

    @Given("^I am on the website \"(.*)\"$")
    public void iAmOnTheWebsite(String url) throws Throwable {
        driver.get(url);
    }

    @Then("^I verify that I can enter first name as (.*)$")
    public void iVerifyThatICanEnterFirstNameAsFirstName(String firstName) throws Throwable {
        driver.findElement(By.id("fn")).sendKeys(firstName);
    }

    @Then("^I verifythat I can enter last nam`e as (.*)$")
    public void iVerifythatICanEnterLastNamEAsLastName(String lastName) throws Throwable {
        webWait(By.xpath("(//input)[4]"), driver);
        driver.findElement(By.xpath("(//input)[4]")).sendKeys(lastName);
    }
}
