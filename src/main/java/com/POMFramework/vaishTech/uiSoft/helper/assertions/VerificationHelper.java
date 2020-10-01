package com.POMFramework.vaishTech.uiSoft.helper.assertions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POMFramework.vaishTech.uiSoft.helper.listener.Retry;
import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;

public class VerificationHelper {
	
	private Logger log = loggerHelper.getlogger(Retry.class);
	private WebDriver driver;
	
	public VerificationHelper(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean isDisplayed(WebElement element) {
		
		try {
			element.isDisplayed();
			log.info("Element is present.."+ element.getText());
			return true;
		} catch (Exception e) {
			log.error("Element is not present", e.getCause());;
			return false;
		}
		
	}

	public boolean isNotDisplayed(WebElement element) {
		
		try {
			element.isDisplayed();
			log.info("Element is present.."+ element.getText());
			return false;
		} catch (Exception e) {
			log.error("Element is not present", e.getCause());;
			return true;
		}
		
	}
	
	public String getText(WebElement element) {
		if(element == null) {
			return null;
		}
		boolean status = isDisplayed(element);
		if(status) {
			
			return element.getText();
		}
		else {
			return null;
		}
		
		
		
	}
	

}
