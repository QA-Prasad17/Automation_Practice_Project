package com.banking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObject.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void loginTEst() {
		driver.manage().window().maximize();

	

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);

		lp.setUserNAme(username);

		logger.info("Enter username");
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}
