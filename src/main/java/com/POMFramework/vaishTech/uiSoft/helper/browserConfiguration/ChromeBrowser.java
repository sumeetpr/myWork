package com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.POMFramework.vaishTech.uiSoft.helper.resources.ResourceHelper;

public class ChromeBrowser {
	
	public ChromeOptions getChromeOptions() {
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--test-type");
		option.addArguments("disable-popup-blocking");
		DesiredCapabilities chrome = new DesiredCapabilities().chrome();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, option);	
		
		return option;
		
	}
	
	public WebDriver getChromeDriver(ChromeOptions option) {
		
		if(System.getProperty("os.name").contains("Window")) {
			
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("\\src\\main\\resources\\drivers\\chromedriver.exe"));
			return new ChromeDriver(option);
		}
		return null;
	}
	
	

}
