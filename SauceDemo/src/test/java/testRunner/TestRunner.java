package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",   // path to your feature files
    glue = "definitions",                   // package containing step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // reports
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
