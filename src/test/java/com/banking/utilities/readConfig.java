package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	public readConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
		
	}
	
	public String getUserName()
	{
		String Username = pro.getProperty("username");
		return Username;
		
	}
	
	public String getPassWord()
	{
		String Password  = pro.getProperty("password");
		return Password;
		
	}
	
	public String getChromePath()
	{
		String chromepath  = pro.getProperty("chromepath");
		return chromepath;
		
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath  = pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
	
	public String getEdgePath()
	{
		String edgepath  = pro.getProperty("edgepath");
		return edgepath;
		
	}
}
