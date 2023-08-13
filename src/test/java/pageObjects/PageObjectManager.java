package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.Generic;

public class PageObjectManager {

	public LandingPage landingPage;
	public OfferPage offerPage;
	public Generic generic;
	public WebDriver driver;
	public CheckoutPage checkoutPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OfferPage getOfferPage() {
		
		offerPage = new OfferPage(driver);
		return offerPage;
	}
	
	public Generic getGenericUtils() {
	generic = new Generic(driver);
	return generic;
	}

	public CheckoutPage getCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
