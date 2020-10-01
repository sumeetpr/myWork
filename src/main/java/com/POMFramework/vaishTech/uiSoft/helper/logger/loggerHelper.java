package com.POMFramework.vaishTech.uiSoft.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.POMFramework.vaishTech.uiSoft.helper.resources.ResourceHelper;

public class loggerHelper {
	
	private static boolean root=false;
	
	
	public static Logger getlogger(Class cls) {
		
		if(root) {
		return Logger.getLogger(cls);
		}
		else {
			
			PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\log4j.properties"));
			root=true;
			return Logger.getLogger(cls);		
		}	
}
//	public static void main(String[] args) {
//		
//		Logger log = loggerHelper.getlogger(loggerHelper.class);
//		log.info("logger got activated");
//		log.info("logger got activated");
//		log.info("logger got activated");
//		
//	}
}
