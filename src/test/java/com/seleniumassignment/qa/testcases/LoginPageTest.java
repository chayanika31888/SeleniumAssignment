package com.seleniumassignment.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.seleniumassignment.qa.base.TestBase;
import com.seleniumassignment.qa.pages.HomePage;
import com.seleniumassignment.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(description="Verify Logo image")

	public void LogoTest(){
		boolean flag = loginPage.isLogoDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(description="Verify 4 tabs")
	public void tabsTest(){

				
	}
	
	@Test(description="Verify pageTitle", priority=2)
	public void loginPageTtileTest(){
		String loginPageTitle = loginPage.loginPageTitle();
		Assert.assertEquals(loginPageTitle, "Altoro Mutual: Online Banking Login");
	}
	
	@Test(description="Verify invalid login")
	public void invalidLoginTest() throws InterruptedException{
		String message = loginPage.invalidLogin("login", "login");
		
		String expectedText = "Login Failed: We're sorry, but this username was not found in our system. Please try again.";
		Assert.assertEquals(message, expectedText);		
	}
	
	@Test(description="Valid Login",groups="Login",priority=1)
	public void validLoginTest() throws InterruptedException{
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		String title = driver.getTitle();
		System.out.println(title);
		String expectedTitle = "Altoro Mutual: Online Banking Home";
		Assert.assertEquals(title, expectedTitle);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
		
	}


