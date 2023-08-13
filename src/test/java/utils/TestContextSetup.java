package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String  productName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public Generic generic;
	
	
	public TestContextSetup() throws IOException {
		testBase= new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		generic = new Generic(testBase.WebDriverManager());
	}

}
