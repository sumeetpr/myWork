package com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.BrowserType;
import com.POMFramework.vaishTech.uiSoft.helper.resources.ResourceHelper;

public class PropertyReader implements ConfigReader{
	
	private static FileInputStream file;
	private static Properties OR;
	
	public PropertyReader() {
		try {
			
			String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\Config.properties");
			 file= new FileInputStream(new File(filePath));
			 OR = new Properties();
			OR.load(file);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public int getImpliciteWait() {
		
		return Integer.parseInt(OR.getProperty("impliciteWait"));
		
	}

	@Override
	public int getExpliciteWait() {
		
		return Integer.parseInt(OR.getProperty("expliciteWait"));
	}

	@Override
	public int getPageLoadTime() {
		
		return Integer.parseInt(OR.getProperty("pageLoadTime"));
	}

	@Override
	public BrowserType getBrowserType() {
		
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

}
