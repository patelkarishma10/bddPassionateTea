package bdd.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Administrator\\ecws\\bddPassionateTea\\src\\test\\java\\bdd\\tests\\Parametisation.feature", glue = {
		"bdd.tests" })

// "C:\\Users\\Administrator\\ecws\\bddPassionateTea\\src\\test\\java\\bdd\\tests\\TeaTesting.feature"
public class Runner {

}
