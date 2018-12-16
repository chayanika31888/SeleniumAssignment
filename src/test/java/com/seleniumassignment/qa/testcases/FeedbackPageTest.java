package com.seleniumassignment.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumassignment.qa.base.TestBase;
import com.seleniumassignment.qa.pages.FeedbackPage;
import com.seleniumassignment.qa.pages.HomePage;
import com.seleniumassignment.qa.utils.TestUtil;

public class FeedbackPageTest extends TestBase{
	
	FeedbackPage feedbackPage;
	TestUtil testUtil;
	HomePage homePage;
	
	String sheetName = "Feedback";
	
	public FeedbackPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
	
	initialization();
	feedbackPage = new FeedbackPage();
	testUtil = new TestUtil();
	}
	
	@DataProvider
	public Object[][] getFeedbackTestData(){
		Object [][] data = testUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=1, dataProvider="getFeedbackTestData")
	public void validateFeedbackForm(String name, String email, String subject, String comments){
		homePage.clickFeedbackLink();
		feedbackPage.submitFeedbackForm(name, email, subject, comments);
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
