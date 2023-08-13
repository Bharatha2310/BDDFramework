Feature: search and place the order for products
	
	@OfferPage
  Scenario Outline: Search experience for product search in both home and offer page
    Given User is on GreenKart landing page
    When user searched with Shortname <Name> and extracted actual name of product
    Then User search for <Name> short name in offer page
		And validate product name in offers page matches with landing page
		
		Examples:
		| Name |
		| Tom  |
		| Beet |