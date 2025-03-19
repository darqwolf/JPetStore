package com.jpetstore.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jpetstore.basepage.BasePage;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    

    @FindBy(name = "keyword")
    WebElement searchBox;

    @FindBy(name = "searchProducts")
    WebElement searchButton;
    
    @FindBy(id= "Catalog")
    WebElement table;

    @FindBy(xpath = "//div[@id='Catalog']/table/tbody")
    WebElement priceList;
    
    
    public void searchForPet(String petName) {
        enterText(searchBox, petName);       
    }

    public void clickSearchButton() {
    	onClick(searchButton);
    } 
    
    public boolean verifyPetList() {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size()>2;
    }
    
    public void clickProductID(String id) {
        WebElement productId = table.findElement(By.linkText(id));
    	onClick(productId);
    }

   public boolean viewDetails() {
	   return priceList.isDisplayed();
   }

}
