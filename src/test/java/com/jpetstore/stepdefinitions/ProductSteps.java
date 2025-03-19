package com.jpetstore.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jpetstore.hooks.Hooks;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

	WebDriver webDriver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(webDriver);
	ProductPage productDetailsPage = new ProductPage(webDriver);
	
	@Given("User logged in with username {string} and password {string}")
	public void user_logged_in_with_username_and_password(String string, String string2) {
		System.out.println("User logged in with username and password");
	    loginPage.navigateTologin();
	    loginPage.enterLoginDetails(string, string2);
        loginPage.clickLogin();
	}

	@When("User clicks on the {string} in the home page")
	public void user_clicks_on_the_in_the_home_page(String string) {
		System.out.println("User clicks on the category in the home page");
		 productDetailsPage.selectCategory(string);
	}

	@When("Clicks on the {string} to view product details")
	public void clicks_on_the_to_view_product_details(String string) {
		System.out.println("Clicks on the product id to view product details");
		productDetailsPage.selectProduct(string);
	}

	@When("Clicks on the {string} to view item details")
	public void clicks_on_the_to_view_item_details(String string) {
		System.out.println("Clicks on the item id to view item details");
		 productDetailsPage.selectItem(string);		 
	}

	@Then("Each row data should match with table data like title {string}, description {string}, availability {string} and price {string}")
	public void each_row_data_should_match_with_table_data_like_title_description_availability_and_price(String string, String string2, String string3, String string4) {
		System.out.println("Each row data should match with table data like title, description, availability and price");
		Assert.assertTrue(productDetailsPage.verifyDetails(string, string2, string3, string4));
		Hooks.capturePassScreenshot(webDriver, "Data_Matches");
	}

	@Then("The product image should be visible")
	public void the_product_image_should_be_visible() throws InterruptedException {
		System.out.println("The product image should be visible");
		Assert.assertTrue(productDetailsPage.isProductImageDisplayed());
		Thread.sleep(2000);
	}

	@When("User adds the product to the cart")
	public void user_adds_the_product_to_the_cart() throws InterruptedException {
		System.out.println("User adds the product to the cart");
		 productDetailsPage.addToCart();
		 Hooks.capturePassScreenshot(webDriver, "Shopping_Cart");
		 Thread.sleep(2000);
	}

	@Then("The product should be successfully added to the cart")
	public void the_product_should_be_successfully_added_to_the_cart() throws InterruptedException {
	   System.out.println("The product should be successfully added to the cart");
	}
}
