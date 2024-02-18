package com.IdentifyNewBikes.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class homePage extends basePage {

	public homePage(WebDriver driver) {
		super(driver);
	}
	
	int h = 0;
	int Nbd = 0;
	int Ucd = 0;
	Actions act = new Actions(driver);
	
	By headerElements = By.xpath("//ul[@class=\"h-d-nav fnt-16 \"]/li/a");
	By newBikesDropDown = By.xpath("//a[text()=\"New Bikes\"]/following-sibling::ul/li");
	By usedCarsDropDown = By.xpath("(//a[text()=\"Used Cars\"]/following-sibling::ul//ul)[2]/li");
	By headingValue = By.xpath("//div[@class=\"col-sm-12\"]//h1");
	
	public boolean headerVerification(String tabName)
	{	
		List<WebElement> lst = driver.findElements(headerElements);		// Find all elements matching the 'headerElements' locator
		boolean flag = false;
	    int setter =0;
	    // Iterate through the elements
		for(WebElement w: lst)
	    {	    	
	    	String str = w.getText();
	    	setter++;
	    	if(str.equalsIgnoreCase(tabName))		// Check if the text is tabName
	    	{
	    		flag = true;
	    		h = setter;
	    		break;		// Break the loop if tabName is found
	    	}
	    	
	    }
		return flag;		 // Return the flag indicating the presence of tabName
	}
	
	public void mouseHover()
	{
		WebElement newBikes = driver.findElement(By.xpath("(//ul[@class=\"h-d-nav fnt-16 \"]/li/a)["+h+"]"));
		act.moveToElement(newBikes).build().perform();
	}
	
	public void clickElement()
	{
		driver.findElement(By.xpath("(//ul[@class=\"h-d-nav fnt-16 \"]/li/a)["+h+"]")).click();
		
	}
	
	public boolean newBikesDropDownVerification(String buttonName) {
		List<WebElement> lst = driver.findElements(newBikesDropDown);		// Find all elements matching the 'dropDownValues' locator
	    boolean flag = false;
	    int setter =0;
	    // Iterate through the elements
	    for(WebElement w: lst)
	    {	    	
	    	String str = w.getText();
	    	setter++;
	    	if(str.equalsIgnoreCase(buttonName))		// Check if the text is buttonName
	    	{
	    		flag = true;
	    		Nbd = setter;
	    		break;		// Break the loop if buttonName is found
	    	}
	    	
	    }
	    return flag;		// Return the flag indicating the presence of buttonName
	}
	
	public void buttonClick()
	{
		WebElement upcommingBikesButton = driver.findElement(By.xpath("(//a[text()=\"New Bikes\"]/following-sibling::ul/li)["+Nbd+"]"));
		act.moveToElement(upcommingBikesButton).click().build().perform();
	}
	
	public boolean usedCarsDropDownVerification(String buttonName) {
		List<WebElement> lst = driver.findElements(usedCarsDropDown);		// Find all elements matching the 'dropDownValues' locator
	    boolean flag = false;
	    int setter =0;
	    // Iterate through the elements
	    for(WebElement w: lst)
	    {	    	
	    	String str = w.getText();
	    	setter++;
	    	if(str.equalsIgnoreCase(buttonName))		// Check if the text is buttonName
	    	{
	    		flag = true;
	    		Ucd = setter;
	    		break;		// Break the loop if buttonName is found
	    	}
	    	
	    }
	    return flag;		// Return the flag indicating the presence of buttonName
	}
	
	public void clickLocation()
	{
		WebElement upcommingBikesButton = driver.findElement(By.xpath("((//a[text()=\"Used Cars\"]/following-sibling::ul//ul)[2]/li)["+Ucd+"]"));
		act.moveToElement(upcommingBikesButton).click().build().perform();
	}
	
	
	
	public String getHeading()
	{
		return(driver.findElement(headingValue).getText());
	}
	
	

}
