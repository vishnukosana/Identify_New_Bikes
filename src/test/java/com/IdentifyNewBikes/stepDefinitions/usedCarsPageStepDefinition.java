package com.IdentifyNewBikes.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.IdentifyNewBikes.pageObjects.homePage;
import com.IdentifyNewBikes.pageObjects.upcomingBikesPage;
import com.IdentifyNewBikes.pageObjects.usedCarsPage;
import com.IdentifyNewBikes.utils.helperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class usedCarsPageStepDefinition {
	homePage hp;
	usedCarsPage uc;

	@Then("Checks whether {string} present in the header section")
	public void checks_whether_present_in_the_header_section(String tabName) {
		hp = new homePage(helperClass.getDriver());
		hp.headerVerification(tabName);
	}

	@When("User hovers the mouse over the Used Cars")
	public void user_hovers_the_mouse_over_the_used_cars() {
		hp.mouseHover();
	}

	@Then("Checks whether {string} is present in the Used cars dropdown")
	public void checks_whether_is_present_in_the_Used_cars_dropdown(String buttonName) {
		boolean flag = hp.usedCarsDropDownVerification(buttonName);
		Assert.assertTrue(flag);
	}

	@When("User clicks on the Chennai button")
	public void user_clicks_on_the_chennai_button() {
		hp.clickLocation("Chennai");
	}


	@Then("User should be navigated to the Used Cars with that {string}")
	public void user_should_be_navigated_to_the_used_cars_with_that(String string) {
		uc = new usedCarsPage(helperClass.getDriver());
		String title = uc.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains(string));
	}

	@When("User select each checkbox of popular models in the filters section")
	public void user_select_each_checkbox_of_popular_models_in_the_filters_section() throws IOException, InterruptedException {
		uc.getPopularModels();
	}

	@When("User clicks on the logo element")
	public void user_clicks_on_the_logo_element() {
		uc.logoClick();
	}

	@Then("User should navigate back to home page")
	public void user_should_navigate_back_to_home_page() {
		String title = uc.getTitle();
		Assert.assertTrue(title.contains("New Cars & Bikes"));
	}

	// regression scenario step definition
	@When("User clicks on the {string} button in Used Cars tab")
	public void user_clicks_on_the_button_in_used_cars_tab(String buttonName) {
		hp = new homePage(helperClass.getDriver());
		hp.usedCarsTab();
		boolean flag = hp.usedCarsDropDownVerification(buttonName);
		hp.clickLocation(buttonName);
	}

	@Given("User navigates to the Used Cars tab in zigwheels")
	public void user_navigates_to_the_used_cars_tab_in_zigwheels() {
		hp  = new homePage(helperClass.getDriver());
		hp.headerVerification("Used Cars");
		hp.mouseHover();
		hp.usedCarsDropDownVerification("Chennai");
		hp.clickLocation("Chennai");
	}

	@When("User select each checkbox and stores the information of popular models in the filters section")
	public void user_select_each_checkbox_and_stores_the_information_of_popular_models_in_the_filters_section() throws InterruptedException, IOException {
		uc = new usedCarsPage(helperClass.getDriver());
		uc.getPopularModels();
	}
	
	@Then("User should be navigated to the Used Cars for Sale tab")
	public void user_should_be_navigated_to_the_used_cars_for_sale_tab() {
	    uc = new usedCarsPage(helperClass.getDriver());
	    String title = uc.getTitle();
	    Assert.assertTrue(title.contains("Used Cars"));
	}

}
