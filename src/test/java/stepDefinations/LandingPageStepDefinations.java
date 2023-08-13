package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinations {
	
	public WebDriver driver;
	public String  productName;
	public String offerProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;
	
	//cucumber.io/docs/cucumber/api/
	
	public LandingPageStepDefinations(TestContextSetup testContextSetup )
	{
		this.testContextSetup = testContextSetup;
		this.landingPage =  testContextSetup.pageObjectManager.getLandingPage();
	}
	
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
	   
		   Assert.assertTrue(landingPage.getTitle().contains("GreenKart"));
	}
	
	@Then("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingPage.searchItem(shortName);
	   Thread.sleep(3000);
	   testContextSetup.productName = landingPage.getProductName().split("-")[0].trim();
	   System.out.println(testContextSetup.productName + " is extracted from Home page");
	}
	
	@When("Added {string} items pf the selected product to cart")
	public void Added_3_items_pf_the_selected_product_to_cart(String quantity) {
	
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
	
}
