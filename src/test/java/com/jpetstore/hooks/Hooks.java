package com.jpetstore.hooks;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.jpetstore.runners.TestNGRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;




public class Hooks {
	public static WebDriver webDriver;
	
	@Before
	public void setUp() {
		String browser = TestNGRunner.browser;
		String url =TestNGRunner.appUrl;
		switch(browser.toLowerCase()) {
		
		case "edge":
			webDriver = new EdgeDriver();
			break;
		case "chrome":
			webDriver =  new ChromeDriver();
			break;
			
		case "firefox":
			webDriver =  new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser not supported");
		}
		
		webDriver.get(url);
		webDriver.manage().window().maximize();

	}
	
	@After
	public void teardown() {
		webDriver.close();
	}
	
	 public static WebDriver getWebDriver() {
	 		return webDriver;
	 	}
	 
	
	public static void capturePassScreenshot(WebDriver webDriver , String screenshot_name) {
		
		String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String path = System.getProperty("user.dir")+ "./PassScreenshots/" + screenshot_name + currentDate + ".jpg";
		
		TakesScreenshot ts  = (TakesScreenshot) webDriver;
		
		File source  = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void captureFailScreenshot(WebDriver webDriver , String screenshot_name) {
		
		String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String path = System.getProperty("user.dir")+ "./FailScreenshots/" + screenshot_name + currentDate + ".jpg";
		
		TakesScreenshot ts  = (TakesScreenshot) webDriver;
		
		File source  = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
}