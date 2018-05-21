package com.jsystems.frontendCucumber.steps;

import com.jsystems.frontendCucumber.FrontendCucumberFactory;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class DataTable extends HelperSteps {
    WebDriver driver;


    public DataTable(FrontendCucumberFactory config) {
        super(config);
        try {
            driver = config.setUp();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(config.id);
        }
    }

    @Given("^website title as tutorial home page of the$")
    public void websiteTitleAsTutorialHomePageOfThe(Map<String, String> dataMap) throws Throwable {
        String website = dataMap.get("website");
        String title = dataMap.get("title");
        System.out.println(dataMap.get("user"));
        driver.get(website);
        assert driver.getTitle().toLowerCase().contains(title);
    }
}
