package com.IdentifyNewBikes.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basePage {
	WebDriver driver;
	
	// Constructor for the basePage class that takes a WebDriver parameter
	public basePage(WebDriver driver) {
		this.driver=driver;		// Assigning the provided WebDriver to the instance variable
		PageFactory.initElements(driver, this); 	// Initializing the PageFactory to enable the use of @FindBy annotations
	}

}
