package com.seleniumassignment.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumassignment.qa.base.TestBase;

public class ThankYouPage extends TestBase{
	
	@FindBy(xpath="//div[@class='fl']/h1")
	WebElement thankyouText;

	public ThankYouPage(){
		PageFactory.initElements(driver, this);
	}
	
	
}
