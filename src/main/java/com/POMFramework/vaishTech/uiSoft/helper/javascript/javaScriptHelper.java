package com.POMFramework.vaishTech.uiSoft.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.WebElement;

import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;
import com.POMFramework.vaishTech.uiSoft.helper.wait.waitHelper;

public class javaScriptHelper {
	
	private Logger log = loggerHelper.getlogger(waitHelper.class);
	private WebDriver driver;
	
	/**
	 * Constructor
	 * @param driver
	 */
	public javaScriptHelper(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	/**
	 * 
	 * @param script
	 * @return
	 */
	public Object executeScript(String script) {
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}

	/**
	 * 
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script, Object... args) {
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script, args);
	}

	/**
	 * 
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		
		executeScript("window.scrollTo(argument[0], argument[1])", element.getLocation().x, element.getLocation().y);
		log.info("Scrolled page to element");
	}
	
	/**
	 * 
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element) {
		
		executeScript("window.scrollTo(argument[0], argument[1])", element.getLocation().x, element.getLocation().y);
		element.click();
		log.info("Scrolled page to element and clicked");
	}
	
	/**
	 * 
	 * @param element
	 */
	public void scrollToView(WebElement element) {
		
		executeScript("argument[0].scrollToView()",element);
		log.info("Scrolled page to element");
	}
	
	/**
	 * 
	 * @param element
	 */
	public void scrollToViewAndClick(WebElement element) {
		
	scrollToView(element);
		element.click();
		log.info("Scrolled page to element and clicked");
	}

	/**
	 * 
	 */
	public void scrollDownVertical() {
		
	
		executeScript("window.scrollTo(0, document.body.scrollHeight");
		log.info("Scrolled down");
	}
	
	/**
	 * 
	 */
	public void scrollUpVertical() {
		
		executeScript("window.scrollTo(0, -document.body.scrollHeight");
		log.info("Scrolled up");
	}

	/**
	 * 
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		
		executeScript("window.scrollBY(0, "+pixel+")");
	}
	
	/**
	 * 
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel) {
		
		executeScript("window.scrollBY(0, -"+pixel+")");
	}
	
	/**
	 * 
	 */
	public void zoomInBy100Percent() {
		
		executeScript("document.body.style.zoom='100%'");
		
		
	}
	
	/**
	 * 
	 */
	public void zoomInBy60Percent() {
		
		executeScript("document.body.style.zoom='60%'");
		
	}
	
	/**98998+989899999
	 * This method is u9ed to click element by javascript.
	 * @param element99
	 */
	public void clickElement(WebElement element) {
		
		executeScript("argument[0].click();", element);
	}

	
}
