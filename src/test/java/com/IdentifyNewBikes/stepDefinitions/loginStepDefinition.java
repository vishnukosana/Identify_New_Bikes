package com.IdentifyNewBikes.stepDefinitions;

import org.testng.Assert;

import com.IdentifyNewBikes.pageObjects.loginPage;
import com.IdentifyNewBikes.utils.helperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinition {
	
	loginPage lp;
	
	@Given("User navigates to the Home page")
	public void user_navigates_to_the_home_page() {
		lp = new loginPage(helperClass.getDriver());
	}

	@When("User clicks the login\\/signup button")
	public void user_clicks_the_login_signup_button() throws InterruptedException {
	    lp.loginClick();
	}

	@When("Clicks on the login as Google")
	public void clicks_on_the_login_as_Google() throws InterruptedException {
	    lp.signInAs();
	}

	@Then("User should be navigated to sign in tab")
	public void user_should_be_navigated_to_sign_in_tab() throws InterruptedException {
	    String actTitle = lp.getTittle();
	    Assert.assertEquals(actTitle, "Sign in - Google Accounts");
	}

	@When("User enters the email in sign in tab")
	public void user_enters_the_email_in_sign_in_tab() {
	    lp.enterEmail();
	}

	@When("Clicks on next button in sign in tab")
	public void clicks_on_next_button_in_sign_in_tab() {
	    lp.clickNext();
	}

	@Then("User checks whether the error message is displayed")
	public void user_checks_whether_the_error_message_is_displayed() {
	    String error = lp.errorMsg();
	    Assert.assertEquals(error, "Couldn’t find your Google Account");
	}




}
