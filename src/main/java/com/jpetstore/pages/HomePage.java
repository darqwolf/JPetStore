package com.jpetstore.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.jpetstore.basepage.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }
}
