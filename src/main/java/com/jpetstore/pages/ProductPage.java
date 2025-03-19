package com.jpetstore.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jpetstore.basepage.BasePage;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage {

	 public ProductPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	    }
	
    @FindBy(id = "QuickLinks")
    WebElement petCategory;

    @FindBy(tagName = "tr")
    List<WebElement> productDetalis;

    @FindBy(xpath = "//div[@id='Catalog']/table/tbody/tr[1]/td/img")
    WebElement productImage;

    @FindBy(xpath = "//div[@id='Catalog']/table/tbody/tr[7]/td/a")
    WebElement addToCartButton;
   
    public void selectCategory(String category) {
      
	WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(15));
	WebElement pet = wait.until(ExpectedConditions.refreshed(
			ExpectedConditions.elementToBeClickable(petCategory)));
	pet.findElement(By.xpath("//descendant::a[contains(@href, '"+category.toUpperCase()+"')]")).click();
    }

    public void selectProduct(String productID) {
        WebElement product = webDriver.findElement(By.linkText(productID));
        onClick(product);
    }

    public void selectItem(String itemID) {
        WebElement item = webDriver.findElement(By.linkText(itemID));
        onClick(item);
    }

    public boolean verifyDetails(String title, String description, String availability, String price) {
        System.out.println("Expected Data: " + title + ", " + description + ", " + availability + ", " + price);
        
        for (int i = 2; i < productDetalis.size() - 1; i++) {
            String rowText = productDetalis.get(i).getText();
            System.out.println("Row " + (i + 1) + " Text: " + rowText);

            if (!rowText.contains(title) && rowText.contains(description) && rowText.contains(availability) && rowText.contains(price)) {
            	System.out.println("Details are incorrect");
                return false;
            }
        }
        System.out.println("Details are correct");
        return true;
    }


    public boolean isProductImageDisplayed() {
        return productImage.isDisplayed();
    }

    public void addToCart() {
        onClick(addToCartButton);
    }

}
