package com.jpetstore.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jpetstore.basepage.BasePage;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    
    @FindBy(name = "keyword")
    WebElement searchField;

    @FindBy(name = "searchProducts")
    WebElement searchButton;

    @FindBy(xpath = "//table/tbody/tr[2]/td[5]/input")
    WebElement quantityField;

    @FindBy(linkText = "Add to Cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//table/tbody/tr[2]/td[4]")
    WebElement inStockField;

    @FindBy(name = "updateCartQuantities")
    WebElement updateCartButton;

    @FindBy(linkText = "Proceed to Checkout")
    WebElement checkoutButton;

    @FindBy(xpath = "//a[text()='Remove']")
    WebElement removeButton;

    public void searchForPet(String petName) {
        enterText(searchField, petName);
        onClick(searchButton);
    }

    public void clickProductById(String productID) {
       onClick(webDriver.findElement(By.linkText(productID)));
    }

    public void clickItemById(String itemID) {
        onClick(webDriver.findElement(By.linkText(itemID)));
    }

    public void addItemToCart() {    
        onClick(addToCartButton);
    }

    public boolean isProductInStock() {
    	String text= inStockField.getText();
    	if(text.contains("true")) {
    		return true;
    	}
    	return false;
    }

    public void updateItemQuantity(String newQuantity) {
        quantityField.clear();
        enterText(quantityField, newQuantity);
        onClick(updateCartButton);
    }

    public void removeItemFromCart() {
        onClick(removeButton);
    }

    public void proceedToCheckout() {
        onClick(checkoutButton);
    }
}
