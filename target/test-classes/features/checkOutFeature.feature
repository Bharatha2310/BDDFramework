Feature: Place the order for products

	@PlaceOrder
  Scenario Outline: Search experience for product search in both home and offer page
  
    Given User is on GreenKart landing page
    When user searched with Shortname <Name> and extracted actual name of product
    And Added "3" items pf the selected product to cart
    Then User proceed to checkout and validate the <Name> items in checkout page
		And verify user has ability to enter promo code and place the order
		
		Examples:
		| Name |
		| Tom  |
		
		

		