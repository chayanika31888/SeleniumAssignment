package com.seleniumassignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumassignment.qa.base.TestBase;
import com.seleniumassignment.qa.testcases.ThankYouPage;

public class FeedbackPage extends TestBase{
	
	@FindBy(xpath="//input[@name='name']")
	WebElement nameField;
	
	@FindBy(xpath="//input[@name='email_addr']")
	WebElement emailField;
	
	@FindBy(xpath="//input[@name='subject']")
	WebElement subjectField;
	
	@FindBy(xpath="//input[@name='comments']")
	WebElement commentsField;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@type='reset']")
	WebElement clearBtn;
	
	
	
	public FeedbackPage(){
		PageFactory.initElements(driver, this);
	}
	
	public ThankYouPage submitFeedbackForm(String name, String email, String subject, String comments){
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		subjectField.sendKeys(subject);
		commentsField.sendKeys(comments);
		submitBtn.click();
		return new ThankYouPage();
	}
	
	public void clearForm(String name, String email, String subject, String comments){
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		subjectField.sendKeys(subject);
		commentsField.sendKeys(comments);
		clearBtn.click();
	}

}
