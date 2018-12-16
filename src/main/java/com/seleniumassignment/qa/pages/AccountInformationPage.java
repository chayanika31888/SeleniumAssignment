package com.seleniumassignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.seleniumassignment.qa.base.TestBase;

public class AccountInformationPage extends TestBase{
	
	@FindBy(id="listAccounts")
	WebElement accountsDropdown;
	
	@FindBy(id="btnGetAccount")
	WebElement selectAccountBtn;
	
	

}
