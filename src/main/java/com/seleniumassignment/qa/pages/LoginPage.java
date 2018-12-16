package com.seleniumassignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumassignment.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	// initialise page factory or object repository(OR) of login page
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="passw")
	WebElement password;
	
	@FindBy(name="btnSubmit")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@src,'logo')]")
	WebElement logo;
	
	@FindBy(id="_ctl0__ctl0_Content_AccountLink")
	WebElement onlineBankingTab;
	
	@FindBy(id="_ctl0__ctl0_Content_LinkHeader2")
	WebElement personalTab;
	
	@FindBy(id="_ctl0__ctl0_Content_LinkHeader3")
	WebElement smallBusinessTab;
	
	@FindBy(id="Header4")
	WebElement insideAltoroMutualTab;
	
	@FindBy(id="_ctl0__ctl0_Content_Main_message")
	WebElement msg;
	
	
	//Initialising the page objects or OR using Page Factory using constructor
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	

	//Actions
	public void enterUserName(String uname){
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public String loginPageTitle(){
		String loginPageTitle = driver.getTitle();
		return loginPageTitle;		
	}
	public HomePage login(String uname, String pwd){
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
		
	}
	public String invalidLogin(String uname, String pwd){
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		String message = msg.getText();
		return message;
		
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean isLogoDisplayed(){
		return logo.isDisplayed();
	}
	
	public boolean isOnlineBankingTabDisplayed(){
		return onlineBankingTab.isDisplayed();
	}
	public boolean isPersonalTabDisplayed(){
		return personalTab.isDisplayed();
	}
	public boolean isSmallBusinessTabDisplayed(){
		return smallBusinessTab.isDisplayed();
	}
	public boolean isInsideAltoroMutualTabDisplayed(){
		return insideAltoroMutualTab.isDisplayed();
	}

}
