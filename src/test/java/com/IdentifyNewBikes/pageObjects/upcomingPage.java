package com.IdentifyNewBikes.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class upcomingPage extends basePage{

	public upcomingPage(WebDriver driver) {
		super(driver);
	}
	
	By manufactureValue = By.xpath("//select[@id=\"makeId\"]");
	By headingValue = By.xpath("//div[@class=\"col-sm-12\"]//h1");
	By readMoreOption = By.xpath("//div[@class=\"clr read-more rm\"]//span");
	
	public void selectManufacture(String value)
	{
		Select obj = new Select(driver.findElement(manufactureValue));
		obj.selectByVisibleText(value);
	}
	
	public String getHeading()
	{
		return(driver.findElement(headingValue).getText());
	}
	
	public void clickViewMore() 
	{
		driver.findElement(readMoreOption).click();
	}
	
	

}
