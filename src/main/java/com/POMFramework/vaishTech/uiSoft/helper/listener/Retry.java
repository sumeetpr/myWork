package com.POMFramework.vaishTech.uiSoft.helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;


public class Retry implements IRetryAnalyzer {
	
	private Logger log = loggerHelper.getlogger(Retry.class);
	private int retryCount = 0;
	private int retryCountMax =3;

	@Override
	public boolean retry(ITestResult result) {
		
		if(retryCount<retryCountMax) {
			
			log.info("Retry test"+result.getName()+ "with status"+getResultStatusName(result.getStatus()) +retryCount+1 +"times.");
			retryCount++;
			return true;
		}
		else {
			
		return false;
		
		}
		
	}
	
	/**
	 * 
	 * @param status
	 * @return
	 */
	public String getResultStatusName(int status) {
		
		if(status==1)
			return "PASS";
		if(status==1)
			return "FAILURE";
		if(status==1)
			return "SKIP";
		
		return null;
	}
	
}
