package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinations {
		public String offerProductName;
		TestContextSetup testContextSetup;
		PageObjectManager pageObjectManager;
		
		public OfferPageStepDefinations(TestContextSetup testContextSetup) {
			this.testContextSetup=testContextSetup;
		}
		
		
		
	@Then("^User search for (.+) short name in offer page$")
	public void user_search_for_same_short_name_in_offer_page(String childShortName) throws InterruptedException {
		switchToOfferPage();
	    OfferPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
	    offerPage.searchItem(childShortName);
	    Thread.sleep(2000);
	    offerProductName=  offerPage.getProductName();
	}
	
	@And("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() 
	{
	Assert.assertEquals(offerProductName, testContextSetup.productName);	
	}

	public void switchToOfferPage() {
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealPage();
		testContextSetup.generic.SwitchWindowToChild();
		
	}
}
