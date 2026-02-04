package com.framework.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.dataproviders.DataProviders;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider = "loginData",
	          dataProviderClass = DataProviders.class)
	    public void validLoginTest(Map<String, String> data) {

	        LoginPage loginPage = new LoginPage();
	        HomePage homePage = new HomePage();
	        
	        String userName = data.get("UserName");
	        String password = data.get("Password");
	        String message = data.get("Expected");
	       
	        homePage.clickFormAuthentication();
	        loginPage.login(userName,password);

	        Assert.assertTrue(
	                loginPage.getSuccessMessage().contains(message)
	            );
	    }

}
