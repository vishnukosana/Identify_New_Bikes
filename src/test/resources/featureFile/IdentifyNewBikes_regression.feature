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
		Given User navigates to the Upcoming honda bikes tab
		When User clicks on the read more option
		And user stores the information of all upcoming Honda bikes
		Then User should be redirected to the Home page 
		
	@Regression	
	Scenario Outline: Navigating to the Used Cars in that location
		Given User navigates to the zigwheels website		
		When User clicks on the "<location name>" button in Used Cars tab
		Then User should be navigated to the Used Cars with that "<location name>"
		
		Examples:
		| 	location name		|
		|		Delhi						|
		|		Hyderabad				|
		|		Mumbai					|
		|		Bangalore				|
		|		Jaipur					|
		|		Chennai					|
		|		Kolkata					|
		|		Pune						|
		|		Ahmedabad				|
		
	@Regression
	Scenario: Getting the car information by selecting each checkbok in popular models filters
		Given User navigates to the Used Cars tab in zigwheels
		When User select each checkbox and stores the information of popular models in the filters section
		
	@Regression
	Scenario: Navigating to the Sign in tab
		Given User navigates to the login/register tab
		When Clicks on the login as Google
		Then User should be navigated to sign in tab

	@Regression
	Scenario: Verifing the error message is displayed in Sign in tab
		Given User navigates to Sign in tab
		When User enters the email in sign in tab
		And Clicks on next button in sign in tab
		Then User checks whether the error message is displayed

