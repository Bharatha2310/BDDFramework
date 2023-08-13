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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPageStepDefinations {
	
	public WebDriver driver;
	public String  productName;
	public String offerProductName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	
	
	public CheckoutPageStepDefinations(TestContextSetup testContextSetup )
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlanOrder());
		
		
	}
	
	@Then("^User proceed to checkout and validate the (.+) items in checkout page$")
	public void User_proceed_to_checkout_and_validate_the_Name_items_in_checkout_page(String name) throws InterruptedException
	{
		checkoutPage.CheckoutItems();
		Thread.sleep(2000);
	}
	
	}
