package com.IdentifyNewBikes.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.IdentifyNewBikes.utils.excelData;

public class usedCarsPage extends basePage{

	public usedCarsPage(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;		// Initializing JavascriptExecutor
	String path = System.getProperty("user.dir")+"\\src/test/resources\\Testdata\\Data.xlsx";
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
	By inputField = By.xpath("//input[@id=\"usedCarCity\"]");
	By popularModel = By.xpath("//div[@class=\"gsc_thin_scroll\"]//label");
	By usedCars = By.xpath("//div[@class=\"pt-10\"]/parent::div/a");
//	By pageDown = By.xpath("//div[@id=\"thatsAllFolks\"]");
	By pageDown = By.xpath("//footer[@id=\"Footer\"]");
	By logoButton = By.xpath("//div[@class=\"col-lg-2\"]/a");
	By heading = By.xpath("//h1[@id=\"usedcarttlID\"]");
	By loaing = By.xpath("//div[@class=\"loaderText\"]");
	
	public void clearText()
	{
		driver.findElement(inputField).clear();
	}
	
	public void enterText(String cityName)
	{
		driver.findElement(inputField).sendKeys(cityName);
	}
	
	public String getTitle()
	{
		return(driver.getTitle());
	}
	
	public void getPopularModels() throws InterruptedException, IOException
	{
		List<WebElement> lst = driver.findElements(popularModel);
		for(WebElement i: lst)
		{
			System.out.println("****************************************************************************");
			System.out.print("Car Model :- ");
			System.out.println(i.getText());
	        js.executeScript("arguments[0].scrollIntoView();", i);
			js.executeScript("arguments[0].click();", i);
//			driver.navigate().refresh();
			scrolldown(i);
			getUsedCars(i.getText().toString());
			js.executeScript("arguments[0].click();", i);
//			driver.navigate().refresh();
//			wait.until(ExpectedConditions.textToBePresentInElementValue(heading, "Used Cars in Chennai"));
			
		}
	}
	
	public void getUsedCars(String sheetname) throws InterruptedException, IOException
	{
//		Thread.sleep(10000);
//		System.out.println("print cars");
		List<WebElement> lst1 = driver.findElements(usedCars);
		System.out.print("Car Model");
		System.out.print("			");
		System.out.print("Car Location");
		System.out.print("			");
		System.out.println("Car prize");
		System.out.println(lst1.size());
		for(int i=1;i<=lst1.size();i++)
		{
			String carName = driver.findElement(By.xpath("(//div[@class=\"pt-10\"]/parent::div/a)["+i+"]")).getText();
			String carLocation = driver.findElement(By.xpath("((//div[@class=\"pt-10\"]/parent::div)["+i+"]/span)[1]")).getText();
			String carPrize = driver.findElement(By.xpath("(//div[@class=\"pt-10\"]/span)["+i+"]")).getText();
			System.out.print(carName);
				System.out.print("		");
				System.out.print(carLocation);
				System.out.print("		");
			System.out.println(carPrize);
			excelData.setCellData(path,sheetname,i, 0, carName);
			excelData.setCellData(path, sheetname, i, 1, carLocation);
			excelData.setCellData(path, sheetname, i, 2, carPrize);
		}
	}
	
	public void scrolldown(WebElement i) throws InterruptedException
	{
		Thread.sleep(10000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String headingData = driver.findElement(heading).getText();
		System.out.println(headingData);
		if(headingData.equals("Used Cars in Chennai"))
		{
			js.executeScript("arguments[0].click();", i);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			js.executeScript("arguments[0].click();", i);
			System.out.println(driver.findElement(heading).getText());
		}
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(pageDown));
		Thread.sleep(20000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void logoClick()
	{
		driver.findElement(logoButton).click();
	}

	
	
	
	
	

}
