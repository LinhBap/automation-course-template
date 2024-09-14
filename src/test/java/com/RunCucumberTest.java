package com;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.steps"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        tags ="not @ignore"
)
@Test
public class RunCucumberTest extends AbstractTestNGCucumberTests{

}
