package com.POMFramework.vaishTech.uiSoft.helper.assertions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.POMFramework.vaishTech.uiSoft.helper.listener.Retry;
import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;

public class AssertionHelper {
	
	private Logger log = loggerHelper.getlogger(Retry.class);
	private WebDriver driver;
	
	public AssertionHelper(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public static void verifyText(String str1, String str2) {
		
		Assert.assertEquals(str1, str2);
	}
	
	public static void markTrue() {
		Assert.assertTrue(true);
		
	}
	public static void markTrue(String str) {
		Assert.assertTrue(true, str);
		
	}
	
	public static void markFalse() {
		Assert.assertFalse(true);
		
	}
	public static void markfalse(String str) {
		Assert.assertFalse(false, str);
		
	}
	
	public static void verifyTrue(Boolean status) {
		Assert.assertTrue(status);
		
	}
	
	public static void verifyFalse(Boolean status) {
		Assert.assertFalse(status);
		
	}
	
	public static void verifyNull(String str) {
		Assert.assertNull(str);
		
	}
	
	public static void verifyNotNull(String str) {
		Assert.assertNotNull(str);
		
	}

}
