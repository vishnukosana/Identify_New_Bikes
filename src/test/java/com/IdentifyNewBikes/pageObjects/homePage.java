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
	
	int s = 0;
	int c = 0;
	Actions act = new Actions(driver);
	
	By headerElements = By.xpath("//ul[@class=\"h-d-nav fnt-16 \"]/li/a");
	By dropDownValues = By.xpath("//a[text()=\"New Bikes\"]/following-sibling::ul/li");
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
	    		s = setter;
	    		break;		// Break the loop if tabName is found
	    	}
	    	
	    }
		return flag;		 // Return the flag indicating the presence of tabName
	}
	
	public void mouseHover()
	{
		WebElement newBikes = driver.findElement(By.xpath("(//ul[@class=\"h-d-nav fnt-16 \"]/li/a)["+s+"]"));
		act.moveToElement(newBikes).build().perform();
	}
	
	public boolean dropDownVerification(String buttonName) {
		List<WebElement> lst = driver.findElements(dropDownValues);		// Find all elements matching the 'dropDownValues' locator
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
	    		c = setter;
	    		break;		// Break the loop if buttonName is found
	    	}
	    	
	    }
	    return flag;		// Return the flag indicating the presence of buttonName
	}
	
	public void buttonClick()
	{
//		By upcommingBikesButton = By.xpath("(//a[text()=\"New Bikes\"]/following-sibling::ul/li)["+c+"]");
//		driver.findElement(upcommingBikesButton).click();
		WebElement upcommingBikesButton = driver.findElement(By.xpath("(//a[text()=\"New Bikes\"]/following-sibling::ul/li)["+c+"]"));
		act.moveToElement(upcommingBikesButton).click().build().perform();
	}
	
	public String getHeading()
	{
		return(driver.findElement(headingValue).getText());
	}
	
	

}
