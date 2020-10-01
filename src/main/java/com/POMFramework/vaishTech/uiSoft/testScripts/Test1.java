package com.POMFramework.vaishTech.uiSoft.testScripts;

import org.testng.annotations.Test;

import com.POMFramework.vaishTech.uiSoft.helper.assertions.AssertionHelper;
import com.POMFramework.vaishTech.uiSoft.testBase.TestBase;

public class Test1 extends TestBase{
	
	@Test
	public void login(){
		
		driver.get("https://www.selenium.dev/selenium-ide/");
		
//		captureScreen("firstscreen");
		AssertionHelper.markTrue();
	
	}
	
//	@Test
//	public void login2(){
//		driver.get("https://www.selenium.dev/selenium-ide/");
//		
//		AssertionHelper.markTrue();
//		
//	
//	}
//	@Test
//	public void login3(){
//		
//		driver.get("https://www.selenium.dev/selenium-ide/");
//		AssertionHelper.markFalse();
//		
//	
//		}

}
