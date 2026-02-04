package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.driver.DriverFactory;

import java.time.Duration;

public class BasePage {

	protected WebDriverWait wait;

	public BasePage() {
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	}

	protected WebElement waitForVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void click(By locator) {
		waitForVisible(locator).click();
	}

	protected void type(By locator, String text) {
		WebElement element = waitForVisible(locator);
		element.clear();
		element.sendKeys(text);
	}

	protected String getText(By locator) {
		return waitForVisible(locator).getText();
	}

	protected boolean isDisplayed(By locator) {
		try {
			return waitForVisible(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
