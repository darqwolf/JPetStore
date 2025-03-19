package com.jpetstore.basepage;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	protected WebDriver webDriver;

	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public WebElement findWebElement(By locator) {
		return webDriver.findElement(locator);
	}
	
	public List<WebElement> findWebElements(By locator) {
		return webDriver.findElements(locator);
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void onClick(WebElement element) {
		element.click();
	}
}