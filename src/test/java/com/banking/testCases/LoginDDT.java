package com.banking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObject.LoginPage;
import com.banking.utilities.XLUtils;

public class LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginDDT")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserNAme(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
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
	
	//user defined method to check alert is present or not
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
	
	@DataProvider(name = "LoginDDT")
	String[][] getData() throws IOException
	{
		//String path = System.getProperty("user.dir") + "/src/test/java/com/banking/testData/PracticeBook.xlsx";
		String path = System.getProperty("user.dir") + "/src/test/java/com/banking/testData/PracticeBook.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; i<colcount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i,j);
			}
		}
		return logindata;
	}

}
