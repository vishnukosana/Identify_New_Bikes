package com.IdentifyNewBikes.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	By newBikesTab = By.xpath("//ul[@class=\"h-d-nav fnt-16 \"]//a[text()=\"New Bikes\"]");
	By usedCarsTab = By.xpath("//ul[@class=\"h-d-nav fnt-16 \"]//a[text()=\"Used Cars\"]");
	By upcomingBikesButton = By.xpath("//a[text()=\"New Bikes\"]/following-sibling::ul//*[text()=\"Upcoming Bikes\"]");
	By buttonClick = By.xpath("//div[@id=\"forum_login_title_lg\"]");
	By loginHeadingValue = By.xpath("(//div[@class=\"fo-nw-step1\"]//span)[1]");
	
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	
	public void clickLocation(String buttonName)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(buttonName.equalsIgnoreCase("Delhi") || buttonName.equalsIgnoreCase("Mumbai")) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"oneTapAlternateLoginPopup\"]//div[@class=\"clr\"]"))));
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id=\"oneTapAlternateLoginPopup\"]//div[@class=\"clr\"]"))));
		}catch(Exception e) {}}
		WebElement upcommingBikesButton = driver.findElement(By.xpath("((//a[text()=\"Used Cars\"]/following-sibling::ul//ul)[2]/li)["+Ucd+"]"));
//		act.moveToElement(upcommingBikesButton).click().build().perform();
		upcommingBikesButton.click();
	}
	
	public void loginClick() throws InterruptedException
	{
		driver.findElement(buttonClick).click();
		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	
	public String getHeading()
	{
		return(driver.findElement(headingValue).getText());
	}
	
	public void newBikesTab()
	{
		act.moveToElement(driver.findElement(newBikesTab)).build().perform();
	}
	
	public void usedCarsTab()
	{
		act.moveToElement(driver.findElement(usedCarsTab)).build().perform();
	}
	
	public void clickUpcomingBikes()
	{
		driver.findElement(upcomingBikesButton).click();
	}
	
	public boolean isDisplayed()
	{
		return(driver.findElement(buttonClick).isDisplayed());
	}
	
	public String tabHeading()
	{
		return(driver.findElement(loginHeadingValue).getText());
	}
	

}
