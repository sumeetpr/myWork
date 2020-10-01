package com.POMFramework.vaishTech.uiSoft.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent == null) {
			
			
			return createInstance("test-output/extent.html");
			
		}
		else {
			
			return extent;
		}
	}
	
	public static ExtentReports createInstance(String fileName) {
		
		ExtentSparkReporter  ExtentHtmlReporter = new ExtentSparkReporter(fileName);
		ExtentHtmlReporter.config().setTheme(Theme.STANDARD);
		ExtentHtmlReporter.config().setDocumentTitle("Automation-Report");
		ExtentHtmlReporter.config().setEncoding("utf-8");
		ExtentHtmlReporter.config().setReportName("Automation-Report");
		extent = new ExtentReports();
		extent.attachReporter(ExtentHtmlReporter);
		return extent;
		
		
	}

}
