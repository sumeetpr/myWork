package com.POMFramework.vaishTech.uiSoft.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.POMFramework.vaishTech.uiSoft.helper.browserConfiguration.config.ObjectReader;
import com.POMFramework.vaishTech.uiSoft.helper.javascript.javaScriptHelper;
import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;
import com.POMFramework.vaishTech.uiSoft.helper.wait.waitHelper;
import com.POMFramework.vaishTech.uiSoft.testBase.TestBase;

public class LoginPage {

	WebDriver driver;
	private final Logger log = loggerHelper.getlogger(LoginPage.class);
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailAddress;
	
	@FindBy(xpath = "//*[@id=\"passwd\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
	WebElement submit;
	
	@FindBy(xpath = "//*[@id=\"email_create\"]")
	WebElement email_create;
	
	@FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
	WebElement SubmitCreate;
	
	@FindBy(xpath = "//*[@id=\"create-account_form\"]/div/p")
	WebElement createAccountText;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper wait = new waitHelper(driver);
		wait.waitForElementClikable(signin, ObjectReader.reader.getExpliciteWait());
		new TestBase().getNavigationScreen(driver);
	}
	
	public void enterEmail(String emailAdress) {
		
		log.info("Entering email address...");
		emailAddress.sendKeys(emailAdress);
		
	}
	
	public void enterPassword(String password) {
		
		log.info("Entering passord...");
		this.password.sendKeys(password);
	}
	
	public HomePage clickOnSubmitButton() {
		
		javaScriptHelper javaScriptHelper = new javaScriptHelper(driver);
		javaScriptHelper.scrollDownVertical();
		submit.click();
		return new HomePage(driver);
	}
	
	
	
	
	
	
	
}
