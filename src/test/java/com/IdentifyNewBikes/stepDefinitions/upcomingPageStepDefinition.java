package com.IdentifyNewBikes.stepDefinitions;

import com.IdentifyNewBikes.pageObjects.upcomingPage;
import com.IdentifyNewBikes.utils.helperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class upcomingPageStepDefinition {
	
	upcomingPage up;
	
	@Given("User navigates to the Upcoming bikes tab")
	public void user_navigates_to_the_upcoming_bikes_tab() {
	    up = new upcomingPage(helperClass.getDriver());
	}

	@When("User selects {string} from the manufacturers dropdown")
	public void user_selects_from_the_manufacturers_dropdown(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be navigated to Upcoming Honda Bike tab")
	public void user_should_be_navigated_to_upcoming_honda_bike_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on the read more option")
	public void user_clicks_on_the_read_more_option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user gets information of all upcoming Honda bikes")
	public void user_gets_information_of_all_upcoming_honda_bikes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be redirected to the Home page")
	public void user_should_be_redirected_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
