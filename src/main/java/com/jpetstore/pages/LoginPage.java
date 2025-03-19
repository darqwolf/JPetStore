package com.jpetstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jpetstore.basepage.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(linkText= "Enter the Store") 
	WebElement enterStore;
	
	 @FindBy(linkText = "Sign In") 
	 WebElement signIn;

	@FindBy(name = "username")
	WebElement usernameField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(name = "signon")
    WebElement loginButton;
	
	@FindBy(id = "WelcomeContent")
    WebElement welcomeMsg;
	
	@FindBy(className ="messages")
	WebElement errorMsg;
	
	public void navigateTologin() {
		onClick(enterStore);
		onClick(signIn);	
	}

    public void enterLoginDetails(String username, String password) {
        enterText(usernameField, username);
        passwordField.clear();
        enterText(passwordField, password);
    }

    public void clickLogin() {
        onClick(loginButton);
    }
    
    public boolean DisplayWelcomeMsg() {
    	return welcomeMsg.isDisplayed();
    }
    
    public boolean DisplayErrorMsg() {
    	return errorMsg.isDisplayed();
    }
}
