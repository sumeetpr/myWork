package com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.config;

import com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.BrowserType;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExpliciteWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	
}
