package com.framework.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.framework.driver.DriverFactory;

public class BrowserFactory {
	
	public static void initDriver(String browser) {
		WebDriver driver;
		
		switch (browser.toLowerCase()) {
		case "Chrome":
			ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options); 
			break;
			
		case "firefox":
			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			fireFoxOptions.addArguments("--start-maximized");
			driver = new FirefoxDriver(fireFoxOptions);
            break;

        case "edge":
        	EdgeOptions edgeOptions = new EdgeOptions();
        	edgeOptions.addArguments("--start-maximized");
        	driver = new EdgeDriver(edgeOptions);
            break;

		default:
			throw new RuntimeException("Unsupported browser: " + browser);
		}
		
		DriverFactory.setDriver(driver);
	}

}
