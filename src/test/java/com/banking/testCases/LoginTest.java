package com.banking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObject.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void loginTEst() throws InterruptedException, IOException {
		driver.manage().window().maximize();

	

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);

		lp.setUserNAme(username);

		logger.info("Enter username");
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();
		captureScreen(driver, "loginTEst");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();  //close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	public boolean isAlertPresent()  
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

}
