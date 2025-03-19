package com.jpetstore.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jpetstore.hooks.Hooks;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	WebDriver webDriver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(webDriver);
	SearchPage searchPage = new SearchPage(webDriver);
	
	@Given("User is logged into JPetStore with username {string} and password {string}")
	public void user_is_logged_into_j_pet_store_with_username_and_password(String string, String string2) {
		System.out.println("User is logged into JPetStore with username and password");
	    loginPage.navigateTologin();
	    loginPage.enterLoginDetails(string, string2);
        loginPage.clickLogin();
	    
	}

	@When("User searches for a pet {string}")
	public void user_searches_for_a_pet(String string) {
		System.out.println("User searches for a pet");
		 searchPage.searchForPet(string);
	}

	@When("Clicks on the search button")
	public void clicks_on_the_search_button() {
		System.out.println("Clicks on the search button");
	    searchPage.clickSearchButton();
	}

	@When("Clicks on the {string} to view details")
	public void clicks_on_the_to_view_details(String string) throws InterruptedException {
		System.out.println("Clicks on the product id to view details");
		Assert.assertTrue(searchPage.verifyPetList());
		searchPage.clickProductID(string);
		Thread.sleep(1000);	
		}

	@Then("Product details should be displayed")
	public void product_details_should_be_displayed() throws InterruptedException {
		System.out.println("Product details should be displayed");
	    Assert.assertTrue(searchPage.viewDetails());
	    Hooks.capturePassScreenshot(webDriver, "Product_Details");
	    Thread.sleep(2000);
	}
	
	@Then("A empty list should be displayed")
	public void a_empty_list_should_be_displayed() throws InterruptedException {
		 Assert.assertFalse(searchPage.verifyPetList());
		 Hooks.captureFailScreenshot(webDriver, "Empty_List");
		 Thread.sleep(2000);	   
	}
}
