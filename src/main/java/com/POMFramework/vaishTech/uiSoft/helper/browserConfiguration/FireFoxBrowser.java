package com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.POMFramework.vaishTech.uiSoft.helper.resources.ResourceHelper;

public class FireFoxBrowser {
	
	public FirefoxOptions getFireFoxOptions() {
		
		DesiredCapabilities fireFox = new DesiredCapabilities().firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		fireFox.setCapability(FirefoxDriver.PROFILE, profile);
		fireFox.setCapability("marionette", true);
		
		FirefoxOptions fireforOption = new FirefoxOptions(fireFox);
		
		return fireforOption;
		
	}
	
	public WebDriver getFirefoxDriver(FirefoxOptions option) {
		
		if(System.getProperty("os.name").contains("window")) {
			
			System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("\\src\\main\\resources\\drivers\\geckodriver.exe"));
			return new FirefoxDriver(option);
		}
		return null;
	}

}
