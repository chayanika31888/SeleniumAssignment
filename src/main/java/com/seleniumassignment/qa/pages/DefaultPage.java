package com.seleniumassignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.seleniumassignment.qa.base.TestBase;

public class DefaultPage extends TestBase{
	
	@FindBy(xpath="//img[contains(@src,'logo')]")
	WebElement logo;
	
	

}
