package com.IdentifyNewBikes.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.IdentifyNewBikes.utils.excelData;

public class upcomingBikesPage extends basePage{

	public upcomingBikesPage(WebDriver driver) {
		super(driver);
	}
	
	List<List<String>> values = new ArrayList<>();
	
	By manufactureValue = By.xpath("//select[@id=\"makeId\"]");
	By headingValue = By.xpath("//div[@class=\"col-sm-12\"]//h1");
	By viewMoreOption = By.xpath("//span[@class=\"zw-cmn-loadMore\"]");
	By bikeList = By.xpath("//div[@class=\"p-15 pt-10 mke-ryt rel\"]");
	By logoButton = By.xpath("//div[@class=\"col-lg-2\"]/a");
	
	String path = System.getProperty("user.dir")+"\\src/test/resources\\Testdata\\Data.xlsx";
	
	
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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		// Initializing JavascriptExecutor
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(viewMoreOption));
		js.executeScript("arguments[0].click();", driver.findElement(viewMoreOption));
	}
	
	public void getBikeInfo() throws IOException
	{
		List<WebElement> lst = driver.findElements(bikeList);
//		System.out.print("Bike Model");
//		System.out.print("			");
//		System.out.print("Expected Bike Prize");
//		System.out.print("		");
//		System.out.println("Expected Launch Date");
//		int row = 1;
		for(int i=1;i<=lst.size();i++)
		{
			String bikeName = driver.findElement(By.xpath("(//div[@class=\"p-15 pt-10 mke-ryt rel\"])["+i+"]/a")).getText();
			String bikePrice = driver.findElement(By.xpath("((//div[@class=\"p-15 pt-10 mke-ryt rel\"])["+i+"]/div)[1]")).getText();
			String launchDate = driver.findElement(By.xpath("((//div[@class=\"p-15 pt-10 mke-ryt rel\"])["+i+"]/div)[2]")).getText();
			String prize = bikePrice.replace("Rs. ", "");
			Double prize2;
			if(prize.contains("Lakh"))
			{
				prize=prize.replace("Lakh", "");
				prize2 = Double.parseDouble(prize);
				prize2=prize2*100000;
				if(prize2<400000)
				{
//					System.out.print(bikeName);
//					System.out.print("		");
//					System.out.print(bikePrize);
//					System.out.print("		");
//					System.out.println(launchDate);
//					excelData.setCellData(path,"upcoming bikes",row, 0, bikeName);
//					excelData.setCellData(path, "upcoming bikes", row, 1, bikePrize);
//					excelData.setCellData(path, "upcoming bikes", row, 2, launchDate);
//					row++;
					values.add(List.of(bikeName,bikePrice,launchDate));
				}
			}
			else if(!prize.contains("Crore"))
			{
//				System.out.print(bikeName);
//				System.out.print("		");
//				System.out.print(bikePrice);
//				System.out.print("		");
//				System.out.println(launchDate);
//				excelData.setCellData(path,"upcoming bikes",row, 0, bikeName);
//				excelData.setCellData(path, "upcoming bikes", row, 1, bikePrice);
//				excelData.setCellData(path, "upcoming bikes", row, 2, launchDate);
//				row++;
				values.add(List.of(bikeName,bikePrice,launchDate));
			}
			
			
		}
		
	}
	
	public void getData() throws IOException
	{
		for (int i = 1; i < values.size(); i++) {
			List<String> row = values.get(i);
			for (int j = 0; j < row.size(); j++) {
				excelData.setCellData(path, "upComing bikes", i, j, row.get(j));
				System.out.print(row.get(j) + "\t");
			}
			System.out.println();
		}
	}
	
	public void homePageNav()
	{
		driver.findElement(logoButton).click();
	}
	
	

}
