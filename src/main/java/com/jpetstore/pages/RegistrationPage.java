package com.jpetstore.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jpetstore.basepage.BasePage;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(linkText= "Enter the Store") WebElement enterStore;
    @FindBy(linkText = "Sign In") WebElement signIn;
    @FindBy(linkText = "Register Now!") WebElement registerNow;

    @FindBy(name = "username") WebElement usernameField;
    @FindBy(name = "password") WebElement passwordField;
    @FindBy(name = "repeatedPassword") WebElement repeatPasswordField;

    @FindBy(name = "account.firstName") WebElement firstNameField;
    @FindBy(name = "account.lastName")  WebElement lastNameField;
    @FindBy(name = "account.email") WebElement emailField;
    @FindBy(name = "account.phone") WebElement phoneField;
    @FindBy(name = "account.address1") WebElement address1Field;
    @FindBy(name = "account.address2") WebElement address2Field;
    @FindBy(name = "account.city") WebElement cityField;
    @FindBy(name = "account.state") WebElement stateField;
    @FindBy(name = "account.zip") WebElement zipField;
    @FindBy(name = "account.country") WebElement countryField;

    @FindBy(name = "account.languagePreference") WebElement languagePreference;
    @FindBy(name = "account.favouriteCategoryId") WebElement favouriteCategory;
    @FindBy(name = "account.listOption") WebElement enableMyList;
    @FindBy(name = "account.bannerOption") WebElement enableMyBanner;

    @FindBy(name = "newAccount") WebElement saveAccountInfoButton;

    public void clickSignIn() {
    	onClick(enterStore);
        onClick(signIn);
    }

    public void clickRegisterNow() {
        onClick(registerNow);
    }

    public void fillUserInformation(String username, String password, String repeatPassword) {
        enterText(usernameField, username);
        enterText(passwordField, password);
        enterText(repeatPasswordField, repeatPassword);
    }

    public void fillAccountInformation(String firstName, String lastName, String email, String phone, String address1, String address2, String city, String state, String zip, String country) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(emailField, email);
        enterText(phoneField, phone);
        enterText(address1Field, address1);
        enterText(address2Field, address2);
        enterText(cityField, city);
        enterText(stateField, state);
        enterText(zipField, zip);
        enterText(countryField, country);
    }

    public void selectProfileInformation(String language, String category) {
        enterText(languagePreference, language);
        enterText(favouriteCategory, category);

        if (!enableMyList.isSelected()) {
            enableMyList.click();
        }

        if (!enableMyBanner.isSelected()) {
            enableMyBanner.click();
        }
    }

    public void clickSaveInformation() {
        onClick(saveAccountInfoButton);
    }
}