package ActivitiesRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "Features",
glue = {"StepDefinitions"},
tags = "@Activity2_2"
)
public class Runner2_2 {

}
