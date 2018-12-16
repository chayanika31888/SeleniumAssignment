package com.seleniumassignment.qa.testcases;

import org.testng.annotations.BeforeMethod;

import com.seleniumassignment.qa.base.TestBase;
import com.seleniumassignment.qa.pages.HomePage;
import com.seleniumassignment.qa.pages.LoginPage;
import com.seleniumassignment.qa.utils.TestUtil;

public class PersonalPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public PersonalPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

}
