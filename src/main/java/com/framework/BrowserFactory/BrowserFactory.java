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

        String projectPath = System.getProperty("user.dir");

        switch (browser.toLowerCase().trim()) {

        case "chrome":
            System.setProperty("webdriver.chrome.driver",
                    projectPath + "/drivers/chromedriver.exe");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            break;

        case "edge":
            System.setProperty("webdriver.edge.driver",
                    projectPath + "/drivers/msedgedriver.exe");

            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");
            driver = new EdgeDriver(edgeOptions);
            break;

        case "firefox":
            System.setProperty("webdriver.gecko.driver",
                    projectPath + "/drivers/geckodriver.exe");

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxOptions);
            break;

        default:
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        DriverFactory.setDriver(driver);
    }

}
