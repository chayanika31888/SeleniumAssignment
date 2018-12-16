package com.seleniumassignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumassignment.qa.base.TestBase;

public class PersonalPage extends TestBase{

	@FindBy(xpath="//a[text()='Deposit Products']")
	WebElement depositProductsLink;
	
	@FindBy(xpath="//a[text()='Checking']")
	WebElement checkingLink;
	
	@FindBy(xpath="//a[text()='Loans']")
	WebElement loansLink;
	
	@FindBy(xpath="//a[text()='Cards']")
	WebElement cardsLink;
	
	@FindBy(xpath="//a[text()='Investments']")
	WebElement investmentsLink;
	
	public PersonalPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String personalPageTitle(){
		
		String personalPageTitle = driver.getTitle();
		return personalPageTitle;
	}
	
	
	
	
}
