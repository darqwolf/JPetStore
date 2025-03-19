package com.jpetstore.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jpetstore.hooks.Hooks;
import com.jpetstore.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration_Steps {
	
	WebDriver webDriver = Hooks.getWebDriver();
	RegistrationPage registrationPage = new RegistrationPage(webDriver);
	
	@Given("User navigates to JPetStore registration page")
	public void user_navigates_to_j_pet_store_registration_page() {
		registrationPage.clickSignIn();
        registrationPage.clickRegisterNow();
	}

	@When("User fills user information with {string}, {string}, {string}")
	public void user_fills_user_information_with(String string, String string2, String string3) {
		 System.out.println("User fills user information");
		 registrationPage.fillUserInformation(string, string2, string3);
	}

	@When("User fills account information with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_fills_account_information_with(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
		System.out.println("User fills account information");
		registrationPage.fillAccountInformation(string, string2, string3, string4, string5, string6, string7, string8, string9, string10);
	}

	@When("User selects profile information {string}, {string}")
	public void user_selects_profile_information(String string, String string2) {
		System.out.println("User selects profile information");
		registrationPage.selectProfileInformation(string, string2);
	}

	@When("Clicks save account information button")
	public void clicks_save_account_information_button() throws InterruptedException {
		System.out.println("Clicks save account information button");
		registrationPage.clickSaveInformation();
		Thread.sleep(3000);
	}

	@Then("User account is successfully created")
	public void user_account_is_successfully_created() throws InterruptedException {
		System.out.println("User account is successfully created");
		String Expected = "https://petstore.octoperf.com/actions/Catalog.action";
		String Actual = webDriver.getCurrentUrl();
		if(Actual.equals(Expected)) {
			Assert.assertTrue(true);
			Hooks.capturePassScreenshot(webDriver, "Registration_Success");
		}
		else {
			Assert.assertFalse(false);
			Hooks.captureFailScreenshot(webDriver, "Registration_Failed");
		}
		
		Thread.sleep(3000);
	}

}