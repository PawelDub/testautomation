package com.jsystems.FrontendCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "classpath:com.jsystems",
        plugin = {"html:target/cucumber-html-report", "rerun:target/rerun.txt"},
        tags = {
                "@wordpress"

        }
)
public class RunTests {
}
