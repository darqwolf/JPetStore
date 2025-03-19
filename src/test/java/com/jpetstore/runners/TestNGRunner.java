package com.jpetstore.runners;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		  features = {"src/test/resources/Features/"},
		  glue = {"com.jpetstore.stepdefinitions" , "com.jpetstore.hooks"},
		  plugin = {
		          "pretty",
		          "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		  },
		  monochrome = true
			
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{

	public static String browser;
	public static String appUrl;
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void setUp(@Optional("edge") String browserParam,
					  @Optional("https://petstore.octoperf.com/") String urlParam) {
		
		browser = browserParam;
		appUrl = urlParam;
	}
}
