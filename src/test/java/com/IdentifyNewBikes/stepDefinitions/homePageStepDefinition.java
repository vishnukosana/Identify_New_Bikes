package com.IdentifyNewBikes.stepDefinitions;



import org.testng.Assert;

import com.IdentifyNewBikes.pageObjects.homePage;
import com.IdentifyNewBikes.utils.helperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homePageStepDefinition {
	
	homePage hp;
	
	@Given("User navigates to the zigwheels website")
	public void user_navigates_to_the_zigwheels_website() {
		hp = new homePage(helperClass.getDriver());
	}

	@Then("Checks whether {string} is present in the header section")
	public void checks_whether_is_present_in_the_header_section(String tabName) {
	    boolean flag = hp.headerVerification(tabName);
	    Assert.assertTrue(flag);
	}
	
	
	@When("User hovers the mouse over the New Bikes")
	public void user_hovers_the_mouse_over_the_new_bikes(){
	    hp.mouseHover();
	}

	@Then("Checks whether {string} is present in the New Bikes dropdown")
	public void checks_whether_is_present_in_the_new_bikes_dropdown(String buttonName) {
		boolean flag = hp.newBikesDropDownVerification(buttonName);
	    Assert.assertTrue(flag);
	}

	@When("User clicks on the Upcoming bikes button")
	public void user_clicks_on_the_upcoming_bikes_button() {
	    hp.buttonClick();
	}

	@Then("User should be navigated to Upcoming bikes tab")
	public void user_should_be_navigated_to_upcoming_bikes_tab() {
	    String actHeading = hp.getHeading();
	    Assert.assertEquals(actHeading, "Upcoming Bikes in India");
	}
}
