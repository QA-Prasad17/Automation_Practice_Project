package com.banking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObject.LoginPage;
import com.banking.pageObject.addCustomerPage;

public class addCustomerTest extends BaseClass{
	
	
	@Test
	public void addNewCustomer() throws InterruptedException
{
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserNAme(username);
		logger.info("Enter username");
		lp.setPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();
		
		
		
		addCustomerPage addcust = new addCustomerPage(driver);
		Thread.sleep(3000);
		
		addcust.clickAddNewCustomer();
		addcust.custName("QAPrasad");
		addcust.custgender("male");
		addcust.custdob("12","17","1992");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("MUM");
		addcust.custstate("MH");
		addcust.custpinno("400069");
		addcust.custtelephoneno("9874563210");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		logger.info("validation startef");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!");
		
		if (res==true) {
			Assert.assertTrue(true);
			logger.info("customer created sucessfully");
		} else {
			Assert.assertTrue(false);
			logger.info("erroe occurs");
		}
		
		
		
		
}
	
	
}