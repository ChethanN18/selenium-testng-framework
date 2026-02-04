package com.framework.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	
	 private By username = By.id("username");
	    private By password = By.id("password");
	    private By loginBtn = By.cssSelector("button[type='submit']");
	    private By successMsg = By.cssSelector("#flash");

	    public void login(String user, String pass) {
	        type(username, user);
	        type(password, pass);
	        click(loginBtn);
	    }

	    public String getSuccessMessage() {
	        return getText(successMsg);
	    }
	}
