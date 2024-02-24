package com.IdentifyNewBikes.utils;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class WebDriverManager {
 
	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
 
	public WebDriver createDriver(String browser) {
		WebDriver driver;
		if (browser.equalsIgnoreCase("chrome")) {
			// Initialize ChromeDriver
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			// Initialize FirefoxDriver
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
 
		driverThreadLocal.set(driver);
		return driverThreadLocal.get();
	}
 
	public void quitDriver() {
		WebDriver driver = driverThreadLocal.get();
		if (driver != null) {
			driver.quit();
		}
	}
 
	public static WebDriver getDriver() {
		return driverThreadLocal.get();
	}
 
	public static WebDriverManager getInstance() {
		return new WebDriverManager();
	}
}