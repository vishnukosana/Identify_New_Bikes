package com.IdentifyNewBikes.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.IdentifyNewBikes.pageObjects.homePage;
import com.IdentifyNewBikes.pageObjects.upcomingBikesPage;
import com.IdentifyNewBikes.utils.helperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class upcomingBikesPageStepDefinition {
	
	upcomingBikesPage up;
	homePage hp;
	
	@Given("User navigates to the Upcoming bikes tab")
	public void user_navigates_to_the_upcoming_bikes_tab() {
	    up = new upcomingBikesPage(helperClass.getDriver());
	}

	@When("User selects {string} from the manufacturers dropdown")
	public void user_selects_from_the_manufacturers_dropdown(String manufactureName) {
	    up.selectManufacture(manufactureName);
	}

	@Then("User should be navigated to Upcoming Honda Bike tab")
	public void user_should_be_navigated_to_upcoming_honda_bike_tab() {
		String actHeading = up.getHeading();
	    Assert.assertEquals(actHeading, "Honda Upcoming Bikes in India");
	}

	@When("User clicks on the read more option")
	public void user_clicks_on_the_read_more_option() {
	    up.clickViewMore();
	}

	@When("user stores the information of all upcoming Honda bikes")
	public void user_stores_the_information_of_all_upcoming_honda_bikes() throws IOException {
	    up.getBikeInfo();
	    up.getData();
	    
	}

	@Then("User should be redirected to the Home page")
	public void user_should_be_redirected_to_the_home_page() {
	    up.homePageNav();
	}
	
	
	//Regresson scenario step definition
	@Given("User navigates to the Upcoming bikes tab in New Bikes dropdown")
	public void user_navigates_to_the_upcoming_bikes_tab_in_new_bikes_dropdown() {
		hp = new homePage(helperClass.getDriver());
		hp.newBikesTab();
		hp.clickUpcomingBikes();
		up = new upcomingBikesPage(helperClass.getDriver());
	}
	
	@Given("User navigates to the Upcoming honda bikes tab")
	public void user_navigates_to_the_upcoming_honda_bikes_tab() {
		hp = new homePage(helperClass.getDriver());
		hp.newBikesTab();
		hp.clickUpcomingBikes();
		up = new upcomingBikesPage(helperClass.getDriver());
		up.selectManufacture("Honda");
	}
	


}
