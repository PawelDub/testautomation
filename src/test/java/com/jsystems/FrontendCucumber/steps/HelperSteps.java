package com.jsystems.FrontendCucumber.steps;

import com.jsystems.FrontendCucumber.FrontendCucumberFactory;
import org.openqa.selenium.WebDriver;

public class HelperSteps {
    WebDriver driver;

    public HelperSteps(FrontendCucumberFactory config) {
        try {
            driver = config.setUp();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(config.id);
        }
    }
}
