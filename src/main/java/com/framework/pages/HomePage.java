package com.framework.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
	
	private By formAuthLink = By.linkText("Form Authentication");

    public void clickFormAuthentication() {
        click(formAuthLink);
    }

}
