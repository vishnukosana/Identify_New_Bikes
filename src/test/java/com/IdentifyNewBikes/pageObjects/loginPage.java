package com.IdentifyNewBikes.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends basePage {

	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	String email = "vggdxcggmail.com";
	JavascriptExecutor js = (JavascriptExecutor) driver;		// Initializing JavascriptExecutor
	
	By buttonClick = By.xpath("//div[@id=\"forum_login_title_lg\"]");
	By loginTab = By.xpath("//div[@class=\"modal fade in\"]");
	By googleSignIn = By.xpath("(//div[@class=\"newgf-login\"])[2]");
	By emailValue = By.xpath("//input[@id=\"identifierId\"]");
	By nextButton = By.xpath("//div[@id=\"identifierNext\"]");
	By error = By.xpath("//span[@class=\"jibhHc\"]/parent::div");
	
	public void loginClick() throws InterruptedException
	{
		driver.findElement(buttonClick).click();
//		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void signInAs() throws InterruptedException
	{
		driver.findElement(googleSignIn).click();
		Thread.sleep(5000);
		List<String> windowId = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowId.get(1));
		
	}
	
	public String getTittle() throws InterruptedException
	{
		return(driver.getTitle());
	}
	
	public void enterEmail()
	{
		driver.findElement(emailValue).sendKeys(email);
	}
	
	public void clickNext()
	{
		driver.findElement(nextButton).click();
	}
	
	public String errorMsg()
	{
		return(driver.findElement(error).getText());
	}

}
