package com.POMFramework.vaishTech.uiSoft.helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;
import com.POMFramework.vaishTech.uiSoft.helper.wait.waitHelper;

public class ExtentListener implements ITestListener{

	private Logger log = loggerHelper.getlogger(ExtentListener.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		
		log.info(result.getName()+"Test started.");
		Reporter.log(result.getName()+"Test started.");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		log.info(result.getName()+"Test Success.");
		Reporter.log(result.getName()+"Test Success.");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		log.info(result.getName()+"Test failed.");
		Reporter.log(result.getName()+"Test failed."+ result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		log.info(result.getName()+"Test skipped.");
		Reporter.log(result.getName()+"Test skipped."+ result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		log.info(context.getName()+"suite started.");
		Reporter.log(context.getName()+"suite started.");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		log.info(context.getName()+"Test finished.");
		Reporter.log(context.getName()+"Test finished.");
		
	}
	
	

}
