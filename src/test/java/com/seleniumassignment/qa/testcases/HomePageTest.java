package com.seleniumassignment.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumassignment.qa.base.TestBase;
import com.seleniumassignment.qa.pages.HomePage;
import com.seleniumassignment.qa.pages.LoginPage;
import com.seleniumassignment.qa.pages.PersonalPage;
import com.seleniumassignment.qa.utils.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	PersonalPage personalPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test	
	public void verifyHomePageTitle(){
		
		String homePagetitle = homePage.homePageTitle();
		Assert.assertEquals(homePagetitle, "Altoro Mutual: Online Banking Home", "Page title donot match");
		
	}
	
	@Test(priority=2)
	public void verifyCorrectUserName(){
		String userNameLabel = homePage.userLabel();
		System.out.println(userNameLabel);
	}
	
	@Test(priority=1)
	public void verifyUserNameIsAvailable(){
		Assert.assertTrue(homePage.userNameLabelAvailable());
	}
	
	@Test
	public void verifyPersonaltabTest(){
		personalPage = homePage.clickPersonalTab();
		String personalPageTitle = personalPage.personalPageTitle();
		Assert.assertEquals(personalPageTitle, "Altoro Mutual", "We are onto Personal Page");
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
