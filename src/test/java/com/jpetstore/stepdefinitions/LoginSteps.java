package com.jpetstore.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jpetstore.hooks.Hooks;
import com.jpetstore.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver webDriver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(webDriver);

	@Given("User is on JPetStore login page")
	public void user_is_on_j_pet_store_login_page() {
		System.out.println("User is on JPetStore login page");
	    loginPage.navigateTologin();
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String string, String string2) throws InterruptedException {
		System.out.println("User enters username and password");
		loginPage.enterLoginDetails(string, string2);
		Thread.sleep(2000);
       
	}

	@When("Clicks on the login button")
	public void clicks_on_the_login_button() {
		System.out.println("Clicks on the login button");
		 loginPage.clickLogin();
	}

	@Then("User should see the homepage")
	public void user_should_see_the_homepage() throws InterruptedException {
		System.out.println("User should see the homepage");
	    Assert.assertTrue(loginPage.DisplayWelcomeMsg());
	    Hooks.capturePassScreenshot(webDriver, "Welcome_Message");
	    Thread.sleep(3000);
	}
	
	@Then("User should see an error message")
	public void user_should_see_an_error_message() throws InterruptedException {
		Assert.assertTrue(loginPage.DisplayErrorMsg());
		Hooks.captureFailScreenshot(webDriver, "Error_Message");
	    Thread.sleep(3000);
	}
}
