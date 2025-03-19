package com.jpetstore.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jpetstore.hooks.Hooks;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.pages.ShoppingCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartSteps {
	
	WebDriver webDriver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(webDriver);
	ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webDriver);
	
	@Given("User login to JPetStore with username {string} and password {string}")
	public void user_login_to_j_pet_store_with_username_and_password(String string, String string2) {
		System.out.println("User login to JPetStore with username and password");
	    loginPage.navigateTologin();
	    loginPage.enterLoginDetails(string, string2);
        loginPage.clickLogin();
	}

	@When("User searches for the pet {string} and clicks on product ID {string}")
	public void user_searches_for_the_pet_and_clicks_on_product_id(String string, String string2) {
		System.out.println("User searches for the pet and clicks on product ID");
		shoppingCartPage.searchForPet(string);
        shoppingCartPage.clickProductById(string2);
	}

	@When("User clicks on item ID {string}")
	public void user_clicks_on_item_id(String string) {
		System.out.println("User clicks on item ID");
		shoppingCartPage.clickItemById(string);
	}

	@When("User adds the product to the cart with quantity")
	public void user_adds_the_product_to_the_cart_with_quantity() {
		System.out.println("User adds the product to the cart with quantity");
		shoppingCartPage.addItemToCart();
	}

	@When("User checks if the product is in stock")
	public void user_checks_if_the_product_is_in_stock() {
		System.out.println("User checks if the product is in stock");
		shoppingCartPage.isProductInStock();
	}

	@When("If product is available, User updates the quantity to {string} and clicks update cart")
	public void if_product_is_available_user_updates_the_quantity_to_and_clicks_update_cart(String string) throws InterruptedException {
		System.out.println("If product is available, User updates the quantity and clicks update cart");
		Assert.assertTrue(shoppingCartPage.isProductInStock());
        shoppingCartPage.updateItemQuantity(string);
        Thread.sleep(1000);
	}

	@Then("User proceeds to checkout")
	public void user_proceeds_to_checkout() throws InterruptedException {
		System.out.println("User proceeds to checkout");
		 shoppingCartPage.proceedToCheckout();
		 Hooks.capturePassScreenshot(webDriver, "CheckOut");
		 Thread.sleep(2000);

	}

	@When("If product is not available, User removes it from the cart")
	public void if_product_is_not_available_user_removes_it_from_the_cart() throws InterruptedException {
		Assert.assertFalse(shoppingCartPage.isProductInStock());
	    shoppingCartPage.removeItemFromCart();
	    Hooks.captureFailScreenshot(webDriver, "Pet_Removed");
	    Thread.sleep(2000);
	}

}
