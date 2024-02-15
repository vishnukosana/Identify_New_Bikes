package com.IdentifyNewBikes.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class helperClass {
	
	static WebDriver driver; 
    static Properties p; 
    static int val;
    
    // Method to initialize a WebDriver instance based on the browser specified in the configuration file.
    public static WebDriver initilizeBrowser() throws IOException {

		switch(getProperties().getProperty("browser").toLowerCase()) 	// Switch statement to determine the browser to initialize.
		{
		case "chrome":
	        driver=new ChromeDriver(); 	// Initialize ChromeDriver if browser is Chrome.
	        break;
	    case "edge":
	    	driver=new EdgeDriver(); 	// Initialize EdgeDriver if browser is Edge.
	        break;
	    case "firefox":
	    	driver=new FirefoxDriver(); 	// Initialize FirefoxDriver if browser is Firefox.
	    	break;
	    default:
	        System.out.println("No matching browser"); 		// Print message if no matching browser is found.
	        driver=null;
		}
		driver.manage().deleteAllCookies(); 	// Delete all cookies before starting the browser session.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 	// Set implicit wait time for WebDriver.
		 
		 return driver; // Return the initialized WebDriver instance.
    	
    }
    
    // Method to get the current WebDriver instance.
    public static WebDriver getDriver() {
		return driver;
	}
    
    // Method to load properties from the configuration file.
    public static Properties getProperties()
	{	
    	try {
    		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties"); // Read configuration file.
       		
	        p=new Properties(); 	// Initialize Properties instance.
			p.load(file); 	// Load properties from the file.
			
    	}
    	catch(Exception e)
    	{
    		// Handle any exceptions that might occur while loading properties.
    	}
    	return p; // Return the loaded Properties instance.
	}
    
    // Method to decode a Base64 encoded string.
    public static String Decoder(String str) {
    	Base64.Decoder decoder = Base64.getUrlDecoder(); 	// Initialize Base64 decoder.
        String dStr = new String(decoder.decode(str)); 	// Decode the input string.
        return dStr; 	// Return the decoded string.
    }
    
    public static int name() {
    	val=val+1;
    	return(val);
    }
    
    public static void captureScreenshot() throws IOException {
    	int i = name();
    	TakesScreenshot ts = (TakesScreenshot) driver;		// Taking a screenshot using the WebDriver
		File source = ts.getScreenshotAs(OutputType.FILE);
	    String dest = System.getProperty("user.dir") +"/ExtentReports/SparkReport/screenshots/screenShot"+i+".png"; 		// Setting destination path for the screenshot
	    File destination = new File(dest);
	    FileUtils.copyFile(source, destination); 		// Copying the screenshot file to the specified destination
    }

}
