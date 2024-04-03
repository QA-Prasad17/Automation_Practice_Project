package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	 public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(name= "uid")
	WebElement txtUserName;
	
	@FindBy(name= "password")
	WebElement txtPassword;
	
	@FindBy(name= "btnLogin")
	WebElement logibtn;
	
	@FindBy(xpath = "//body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	WebElement logoutbtn;
	
	
	
	
	public void setUserNAme(String Uname)
	{
		txtUserName.sendKeys(Uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		logibtn.click();
	}
	
	public void clickLogout()
	{
		logoutbtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}

