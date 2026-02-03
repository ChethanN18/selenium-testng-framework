package com.framework.driver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	 
	 private DriverFactory() {
		// prevent object creation
	 }
	 
	 public static WebDriver getDriver() {
	        return driver.get();
	    }
	 
	 public static void setDriver(WebDriver webDriver) {
		 driver.set(webDriver);
		 
	 }
	 
	 public static void unload() {
		 WebDriver driverInstance = getDriver();
		 if (driverInstance != null) {
			 driverInstance.quit();
		        driver.remove(); // remove()
		    }
	        
	    }
}
