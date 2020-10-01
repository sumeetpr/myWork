package com.POMFramework.vaishTech.uiSoft.testBase;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.BrowserType;
import com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.ChromeBrowser;
import com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.FireFoxBrowser;
import com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.config.ObjectReader;
import com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.config.PropertyReader;
import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;
import com.POMFramework.vaishTech.uiSoft.helper.resources.ResourceHelper;
import com.POMFramework.vaishTech.uiSoft.helper.wait.waitHelper;
import com.POMFramework.vaishTech.uiSoft.utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestBase {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = loggerHelper.getlogger(TestBase.class);
	public static String reportDirectory;

	
	@BeforeSuite
	public void beforeSuite() {
		
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	public void beforeClass() {
		
		test = extent.createTest(getClass().getSimpleName());
		
	}
	
	@org.testng.annotations.BeforeTest
	public void BeforeTest() {
		
		ObjectReader.reader = new PropertyReader();
		reportDirectory= ResourceHelper.getResourcePath("\\src\\main\\resources\\screenShots");
		setUpDriver(ObjectReader.reader.getBrowserType());
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		test.log(Status.INFO, method.getName() + " Started.");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreen(result.getName(), driver);
			try {
				test.addScreenCaptureFromPath(imagePath);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			
			test.log(Status.PASS, result.getName()+" passed.");
			String imagePath = captureScreen(result.getName(), driver);
			try {
				test.addScreenCaptureFromPath(imagePath);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		if(result.getStatus() == ITestResult.SKIP) {
			
			test.log(Status.SKIP, result.getThrowable());
		}
		
		extent.flush();
		
		
	}
	
	@AfterTest
	public void afterTest() {
		
		if (driver!=null) {
			
			driver.quit();
		}
	}
		public WebDriver getBrowserObject(BrowserType bType) {
			
			try {
				switch (bType) {
				case Chrome:
					ChromeBrowser chrome = new ChromeBrowser();
					ChromeOptions option = chrome.getChromeOptions();
					return chrome.getChromeDriver(option);
				case FireFix:
					FireFoxBrowser firefox = new FireFoxBrowser();
					FirefoxOptions options = firefox.getFireFoxOptions();
					return firefox.getFirefoxDriver(options);
				default:
					throw new Exception("Driver not found."+ bType.name());
				}
			} catch (Exception e) {
				log.info(e.getMessage());
				e.printStackTrace();
			}
			return null;
	
		
		}
		
		public void setUpDriver(BrowserType bType) {
			
			driver = getBrowserObject(bType);
			waitHelper wait = new waitHelper(driver);
			wait.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
			wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
			driver.manage().window().maximize();
			log.info("WebDriver initialized"+ driver.hashCode());
			
		}
		
		public String captureScreen(String fileName, WebDriver driver) {
			
			Calendar calender = Calendar.getInstance();
			SimpleDateFormat formator = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
			File destFile=null;
			try {
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				destFile = new File(reportDirectory+"/"+fileName+"_"+formator.format(calender.getTime())+".png");
				Files.copy(file.toPath(), destFile.toPath());
				Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
				
			} catch (Exception e) {
				e.getStackTrace();
			}
			return destFile.toString();	
			
		}
		
		public void getNavigationScreen(WebDriver driver) {
			
			log.info("capturing UI nanigagtion screens.");
			String screen = captureScreen("", driver);
			try {
				test.addScreenCaptureFromPath(screen);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
}
