package com.POMFramework.vaishTech.uiSoft.helper.resources;

public class ResourceHelper {
	
	public static String getResourcePath(String path) {
		
		String resourcePath = System.getProperty("user.dir");
		return resourcePath + path;
		
	}

//	public static void main(String[] args) {
//		
//		System.out.println(ResourceHelper.getResourcePath("\\src\\main\\java\\com\\POMFramework\\vaishTech\\uiSoft\\helper\\resources")); 
//	}
}
