package com.IdentifyNewBikes.stepDefinitions;

import org.testng.Assert;

import com.IdentifyNewBikes.pageObjects.homePage;
import com.IdentifyNewBikes.pageObjects.loginPage;
import com.IdentifyNewBikes.utils.helperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinition {
	
	loginPage lp;
	homePage hp;
	
	@Given("User navigates to the Home page of zigwheels")
	public void user_navigates_to_the_Home_page_zigwheels() {
		hp = new homePage(helperClass.getDriver());
	}

	@Then("Checks whether login\\/signup is present in the zigwheels tab")
	public void checks_whether_login_signup_is_present_in_the_zigwheels_tab() {
	    boolean value = hp.isDisplayed();
	    Assert.assertTrue(value);
	}
	
	@When("User clicks the login\\/signup button")
	public void user_clicks_the_login_signup_button() throws InterruptedException {
	    hp.loginClick();
	}

	@When("Clicks on the login as Google")
	public void clicks_on_the_login_as_Google() throws InterruptedException {
		lp = new loginPage(helperClass.getDriver());
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
	
	//smoke scenario step definition
	@Then("User should be navigated to login\\/register tab")
	public void user_should_be_navigated_to_login_register_tab() {
	    String actValue = hp.tabHeading();
	    Assert.assertEquals(actValue, "Login/Register to ZigWheels");
	}
	
	@Given("User navigates to the login\\/register tab")
	public void user_navigates_to_the_login_register_tab() throws InterruptedException {
		hp = new homePage(helperClass.getDriver());
		hp.loginClick();
		
	}
	
	@Given("User navigates to Sign in tab")
	public void user_navigates_to_sign_in_tab() throws InterruptedException {
		hp = new homePage(helperClass.getDriver());
		hp.loginClick();
		lp = new loginPage(helperClass.getDriver());
	    lp.signInAs();
	}



}
