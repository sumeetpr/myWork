package com.POMFramework.vaishTech.uiSoft.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;
import com.POMFramework.vaishTech.uiSoft.helper.wait.waitHelper;

public class frameHelper {
	
	private Logger log = loggerHelper.getlogger(waitHelper.class);
	private WebDriver driver;
	
	public frameHelper(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	/**
	 * This method can be used to switch to frame.
	 * @param frameIndex
	 */
	public void switchToFrame(int frameIndex) {
		
		driver.switchTo().frame(frameIndex);
		log.info("driver switched to frame");
	}

	/**
	 * This method can be used to switch to frame.
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		
		driver.switchTo().frame(element);
		log.info("driver switched to frame");
	}

	/**
	 * This method can be used to switch to frame.
	 * @param frameName
	 */
	public void switchToFrame(String frameName) {
	
	driver.switchTo().frame(frameName);
	log.info("driver switched to frame");
	}
	
	/**
	 * This method can be used to switch to parentFrame.
	 */
	public void switchToParentFrame() {
		
		driver.switchTo().parentFrame();
		log.info("driver switched to parentFrame");
	}
}
