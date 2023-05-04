package com.chase;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Cucumber Test Runner class
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.chase.steps",
        tags="@News-Validator",
        plugin = { "pretty", "html:target/cucumber-reports.html" }
)
public class Runner {
}