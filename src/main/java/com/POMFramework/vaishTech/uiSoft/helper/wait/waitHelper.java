package com.POMFramework.vaishTech.uiSoft.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;

public class waitHelper {
	
	private Logger log = loggerHelper.getlogger(waitHelper.class);
	private WebDriver driver;
	
	public waitHelper(WebDriver driver) {
		
		this.driver=driver;
	}

	/**
	 * This Method will set implicit time.
	 * @param timeOut
	 * @param unit
	 */
	public void setImplicitWait(long timeOut, TimeUnit unit) {
		
		log.info("Implicit wait is set to" + timeOut);
		driver.manage().timeouts().implicitlyWait(timeOut, unit);
		
	}
	
	/**
	 * This Method will help to get WebDriverWait Object.
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilisec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMilisec) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMilisec));
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(NoSuchFrameException.class);
		
		return wait;
	}
	
	/**
	 * This Method will make sure element is visible.
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilisec
	 */
	public void waitForElementVisileWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMilisec) {
		
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMilisec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now");	
	}
	
	/**
	 * This Method will make sure element is clikable.
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementClikable(WebElement element, int timeOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clikable now");	
	}
	
	/**
	 * This Method will make sure element not present.
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementNotPresent(WebElement element, int timeOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is not invisible now");	
		
	}
	
	/**
	 * This Method will make sure frame is available and switched.
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is available and switched");	
		
	}
	
	/**
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilisec
	 * @return
	 */
	public FluentWait<WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMilisec) {
		
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofMillis(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMilisec))
				.ignoring(NoSuchElementException.class);
		
		return fwait;
	}
	
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMilisec
	 */
	public void waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMilisec) {
		
		FluentWait<WebDriver> fwait = getFluentWait(timeOutInSeconds, pollingEveryInMilisec);
		fwait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will make sure page is loaded completely.
	 * @param timeOutInSeconds
	 * @param unit
	 */
	public void pageLoadTime(int timeOutInSeconds, TimeUnit unit) {
		
		log.info("waiting for page to get load.");
		driver.manage().timeouts().pageLoadTimeout(timeOutInSeconds, unit);
		log.info("Page Loaded.");
	}
}
