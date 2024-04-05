package com.banking.testCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.banking.utilities.readConfig;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class BaseClass {

	readConfig ReadConfig = new readConfig();
	
	
	public String baseURL = ReadConfig.getApplicationURL();
	public String username = ReadConfig.getUserName();
	public String password = ReadConfig.getPassWord();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br	)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", ReadConfig.getChromePath());
		ChromeOptions options = new ChromeOptions();

        // Add argument to run Chrome in incognito mode
        options.addArguments("--incognito");

        // Create a new instance of ChromeDriver with options
       
		driver = new ChromeDriver(options);
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ReadConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge .driver", ReadConfig.getEdgePath());
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
		}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
	   String generatedString = RandomStringUtils.randomAlphabetic(5);
	   return (generatedString);
	}
	
	public static String randomenum()
	{
	   String generatedString2 = RandomStringUtils.randomNumeric(4);
	   return (generatedString2);
	}
	
}
