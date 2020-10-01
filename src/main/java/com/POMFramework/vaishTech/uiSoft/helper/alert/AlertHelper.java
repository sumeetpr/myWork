package com.POMFramework.vaishTech.uiSoft.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.POMFramework.vaishTech.uiSoft.helper.listener.Retry;
import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;

public class AlertHelper {
	
	private Logger log = loggerHelper.getlogger(Retry.class);
	private WebDriver driver;
	
	public AlertHelper(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public Alert getAlert() {
		
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		
		getAlert().accept();
		
	}
	
	public void dismissAlert() {
		
		getAlert().dismiss();
		
	}
	
	public String getAlertText() {
		
		return getAlert().getText();
	}
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			log.info("Alert is not present");
			return false;
		}
	}
	
	public void acceptAlertIfPresent() {
		
		if (isAlertPresent()) {
			
			acceptAlert();
		}
		else {
			log.info("Alert is not present");
		}
	}
	
	public void dismissAlertIfPresent() {
		
		if (isAlertPresent()) {
			
			dismissAlert();
		}
		else {
			log.info("Alert is not present");
		}
	}
	
	public void acceptPrompt(String str) {
		
		if (isAlertPresent()) {
			
			getAlert().sendKeys(str);
			acceptAlert();
		}
		else {
			log.info("Prompt is not present");
		}
	}
	
}
