package com.IdentifyNewBikes.testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(features= {"src//test//resources//featureFile//IdentifyNewBikes.feature"},		// Specifying the location of the feature file(s) that contain Gherkin syntax
				 glue= {"com.IdentifyNewBikes.stepDefinitions"},	// Specifying the package containing step definitions
				 plugin= {"pretty","html:Cucumberreport/myreport1.html" ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}		// Plugins for generating different types of reports
				
				)

//The class extending AbstractTestNGCucumberTests to run Cucumber with TestNG
@Test
public class testRun extends AbstractTestNGCucumberTests{

}
