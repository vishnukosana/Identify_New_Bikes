Feature: Identify New Bikes
	
	@Smoke
	Scenario Outline: Verifying the header section of zigwheels
		Given User navigates to the zigwheels website
		Then Checks whether "<tab name>" is present in the header section
		
		Examples:
		|		tab name		|
		|		New Bikes		|
		|		Used Cars		|
		
	@Smoke
	Scenario: Verifying the dropdown of New Bikes
		Given User navigates to the zigwheels website
		When User hovers the mouse over the New Bikes in header section
		Then Checks whether "<button name>" is present in the New Bikes dropdown
		
		Examples:
		|		button name			|
		|		Upcoming Bikes	|
		
	@Smoke
	Scenario: Verifying the New Bikes dropdown
		Given User navigates to the zigwheels website
		When User clicks on the Upcoming bikes button in New Bikes tab
		Then User should be navigated to Upcoming bikes tab
		
	@Smoke
	Scenario: Navigating to the Used Cars for Sale tab
		Given User navigates to the zigwheels website
		When User hovers the mouse over the Uesed cars in header section
		Then User should be navigated to the Used Cars for Sale tab
		
	@Smoke
	Scenario: Verifying the login/signup button in zigwheels
		Given User navigates to the Home page of zigwheels
		Then Checks whether login/signup is present in the zigwheels tab
		
	@Smoke
	Scenario: Navigating to the login/register tab
		Given User navigates to the Home page of zigwheels
		When User clicks the login/signup button
		Then User should be navigated to login/register tab
		