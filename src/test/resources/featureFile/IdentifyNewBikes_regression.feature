Feature: Identify New Bikes
	
	@Regression
	Scenario: Navigating to the Upcoming Honda Bike tab
		Given User navigates to the Upcoming bikes tab in New Bikes dropdown
		When User selects "<manufacture name>" from the manufacturers dropdown
		Then User should be navigated to Upcoming Honda Bike tab
		
		Examples:
		|		manufacture name		|
		|		Honda								|
		
	@Regression
	Scenario: Getting the upcoming honda bikes information
		Given User navigates to the Upcoming Honda bikes tab
		When User clicks on the read more option
		And user gets information of all upcoming Honda bikes
		Then User should be redirected to the Home page 
		
	@Regression	
	Scenario: Navigating to the Used Cars in that location
		Given User navigates to the Used Cars tab		
		When User sets the "<location name>" in filters section
		Then User gets the information of Used cars in that location
		
		Examples:
		| 	location name		|
		|		Chennai					|
		
	@Regression
	Scenario: Getting the car information by selecting each checkbok in popular models filters
		Given User navigates to the Used Cars tab
		When User select each checkboxe of popular models in the filters section
		Then User gets the car information of respective clicked checkbox model
		
	@Regression
	Scenario: Navigating to the Sign in tab
		Given User navigates to the login/register tab
		When User clicks on the login as "<account type>"
		Then User should be navigated to Sign in tab
		
		Examples:
		|		account type		|
		|		Google					|
		
	@Regression
	Scenario: Verifing the error message is displayed in Sign in tab
		Given User navigates to Sign in tab
		And Clicks on next button in sign in tab
		Then User checks whether the error message is displayed
		
		
		
		