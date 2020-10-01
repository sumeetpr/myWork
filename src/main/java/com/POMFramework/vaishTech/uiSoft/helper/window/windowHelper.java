package com.POMFramework.vaishTech.uiSoft.helper.window;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;
import com.POMFramework.vaishTech.uiSoft.helper.wait.waitHelper;

public class windowHelper {

	private Logger log = loggerHelper.getlogger(waitHelper.class);
	private WebDriver driver;
	
	/**
	 * 
	 * @param driver
	 */
	public windowHelper(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	/**
	 * This method will make sure driver switch to parent window.
	 */
	public void switchToParentWindow() {
		
		
		driver.switchTo().defaultContent();
		log.info("driver switch to parent window");
	}
	
	/**
	 * This method will make sure driver switch to desired window.
	 * @param index
	 */
	public void switchToWindow(int index) {
		
		Set<String> windows = driver.getWindowHandles();
		
		int i = 1;
		
		for (String window : windows) {
			
			if(i == index) {
				
				log.info("driver switching desire window");
				driver.switchTo().window(window);
				log.info("driver switched desire window");
			}
			else {
				
				i++;
			}
		}
	}
	
	/**
	 * This method will make sure all tabs are closed and driver switch to parent window.
	 */
	public void closeAllTabAndswitchToMainWindow() {
		
		Set<String> windows = driver.getWindowHandles();
		String parentWinodw = driver.getWindowHandle();
		
		for (String window : windows) {
			
			if(!window.equalsIgnoreCase(parentWinodw)) {
				
				driver.close();
				
			}	
		}
		
		driver.switchTo().defaultContent();
		log.info("All tabs are closed and driver switched to parent window");
	}
	
	/**
	 * This method will do browser back navigation.
	 */
	public void navigateBack() {
		
		driver.navigate().back();
		log.info("Browser navigated back");
	}
	
	/**
	 * This method will do browser forward navigation.
	 */
	public void navigateForward() {
		
		driver.navigate().forward();
		log.info("Browser navigated forward");
	}
	
}
