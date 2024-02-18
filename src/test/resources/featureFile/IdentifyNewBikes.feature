Feature: Identify New Bikes
	
	@Smoke
	Scenario: Home page functionality
		Given User navigates to the zigwheels website
		Then Checks whether "<tab name>" is present in the header section
		When User hovers the mouse over the New Bikes
		Then Checks whether "<button name>" is present in the New Bikes dropdown
		When User clicks on the Upcoming bikes button
		Then User should be navigated to Upcoming bikes tab
		
		Examples:
		|		tab name		|		button name			|
		|		New Bikes		|		Upcoming Bikes	|
		
	@Regression
	Scenario: Navigating to the Upcoming Honda Bike tab
		Given User navigates to the Upcoming bikes tab
		When User selects "<manufacture name>" from the manufacturers dropdown
		Then User should be navigated to Upcoming Honda Bike tab
		When User clicks on the read more option
		And user gets information of all upcoming Honda bikes
		Then User should be redirected to the Home page 
		
		Examples:
		|		manufacture name		|
		|		Honda								|
	
	@Smoke @Regression	
	Scenario: Navigating to the Used Cars for Sale tab
		Then Checks whether "<tab name>" present in the header section
		When User hovers the mouse over the Used Cars
		Then Checks whether "<button name>" is present in the Used cars dropdown
		When User clicks on the Chennai button
		Then User should be navigated to the Used Cars for Sale tab
		When User select each checkbox of popular models in the filters section
		And User clicks on the logo element
		Then User should navigate back to home page 
		
		Examples:
		|		tab name		|		button name 	|
		|		Used Cars		|		Chennai				|
	
	@Regression	
	Scenario: Login functionality
		Given User navigates to the Home page
		When User clicks the login/signup button
		And Clicks on the login as Google
		Then User should be navigated to sign in tab
		When User enters the email in sign in tab
		And Clicks on next button in sign in tab
		Then User checks whether the error message is displayed
		
		
		