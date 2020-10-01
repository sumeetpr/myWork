package com.POMFramework.vaishTech.uiSoft.helper.select;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.POMFramework.vaishTech.uiSoft.helper.listener.Retry;
import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;

public class DropdownHelper {
	
	private Logger log = loggerHelper.getlogger(Retry.class);
	private WebDriver driver;
	
	public DropdownHelper(WebDriver driver) {
		
		this.driver = driver;
		log.info("Dropdown object created.");
	}
	
	public void selectUsingValue(WebElement element, String value) {
		
		Select select = new Select(element);
		select.selectByValue(value);
		log.info("Option selected.");
	}
	
	public void selectUsingIndex(WebElement element, int index) {
		
		Select select = new Select(element);
		select.selectByIndex(index);
		log.info("Option selected.");
	}
	
	public void selectUsingIndex(WebElement element, String text) {
		
		Select select = new Select(element);
		select.selectByVisibleText(text);
		log.info("Option selected.");
	}

public void deselectUsingValue(WebElement element, String value) {
		
		Select select = new Select(element);
		select.deselectByValue(value);
		log.info("Option deselected.");
	}
	
	public void deselectUsingIndex(WebElement element, int index) {
		
		Select select = new Select(element);
		select.deselectByIndex(index);
		log.info("Option deselected.");
	}
	
	public void deselectUsingIndex(WebElement element, String text) {
		
		Select select = new Select(element);
		select.deselectByVisibleText(text);
		log.info("Option deselected.");
	}
	
	
	public List<String> getAllDropdowndata(WebElement element) {
		
		Select select = new Select(element);
		List<WebElement> allOption = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for (WebElement webelement : allOption) {
			 valueList.add(webelement.getText());
		}
		
		return valueList;
	}
	

}
