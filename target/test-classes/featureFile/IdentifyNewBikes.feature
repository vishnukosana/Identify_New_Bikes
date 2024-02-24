Feature: Identify New Bikes
	
	@Smoke
	Scenario: Navigating to the Upcoming Honda Bike tab
		Given User navigates to the zigwheels website
		Then Checks whether "<NewBikes tab>" is present in the header section
		When User hovers the mouse over the New Bikes
		Then Checks whether "<UpcomingBikes button>" is present in the New Bikes dropdown
		When User clicks on the Upcoming bikes button
		Then User should be navigated to Upcoming bikes tab
		Given User navigates to the Upcoming bikes tab
		When User selects "<manufacture name>" from the manufacturers dropdown
		Then User should be navigated to Upcoming Honda Bike tab
		When User clicks on the read more option
		And user stores the information of all upcoming Honda bikes
		Then User should be redirected to the Home page 
		
		Examples:
		|		NewBikes tab		|		UpcomingBikes button		|		manufacture name		|
		|		New Bikes				|		Upcoming Bikes					|		Honda								|
		
	Scenario: Navigating to the Used Cars for Sale tab
		Given User navigates to the zigwheels website
		Then Checks whether "<UsedCars tab>" present in the header section
		When User hovers the mouse over the Used Cars
		Then Checks whether "<location name>" is present in the Used cars dropdown
		When User clicks on the Chennai button
		Then User should be navigated to the Used Cars with that "<location name>"
		When User select each checkbox of popular models in the filters section
		And User clicks on the logo element
		Then User should navigate back to home page
		
		Examples:
		|		UsedCars tab		|		location name		|
		|		Used Cars				|		Chennai					|
		
	Scenario: login functionality
		Given User navigates to the Home page of zigwheels
		When User clicks the login/signup button
		And Clicks on the login as Google
		Then User should be navigated to sign in tab
		When User enters the email in sign in tab
		And Clicks on next button in sign in tab
		Then User checks whether the error message is displayed
		
	