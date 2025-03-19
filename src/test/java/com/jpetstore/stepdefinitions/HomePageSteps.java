package com.jpetstore.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jpetstore.hooks.Hooks;
import com.jpetstore.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {

	WebDriver webDriver = Hooks.getWebDriver();
	HomePage homePage = new HomePage(webDriver);
	@Given("User is on JPetStore homepage")
	public void user_is_on_j_pet_store_homepage() {
		System.out.println("User is on JPetStore homepage");
	}

	@Then("Verify the page URL")
	public void verify_the_page_url() {
	   System.out.println("Verify the page URL");
	   String expectedUrl = "https://petstore.octoperf.com/";
	   Assert.assertEquals(homePage.getPageURL(), expectedUrl);
	}

	@Then("Verify the page title")
	public void verify_the_page_title() throws InterruptedException {
		System.out.println("Verify the page title");
		String expectedTitle = "JPetStore Demo";
		Assert.assertEquals(homePage.getPageTitle(), expectedTitle);
		Hooks.capturePassScreenshot(webDriver, "Homepage");
		Thread.sleep(2000);
	}
}
