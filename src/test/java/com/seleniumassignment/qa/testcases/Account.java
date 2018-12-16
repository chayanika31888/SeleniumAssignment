package com.seleniumassignment.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Account {

	WebDriver driver = new ChromeDriver();
	
	@Test(dependsOnGroups="Login", description="AccountsPageInformation")
	public void OnlineBanking(){
		
	driver.get("http://demo.testfire.net/bank/main.aspx");
	Select account = new Select(driver.findElement(By.id("listAccounts")));
	account.selectByValue("1001160141");
	
	driver.findElement(By.id("btnGetAccount")).click();
	String expectedTitle = "Altoro Mutual: Account Information";
	String title = driver.getTitle();
	Assert.assertEquals(title, expectedTitle);
	WebElement s1 = driver.findElement(By.id("_ctl0__ctl0_Content_Main_accountid"));
	String s2="1001160141";
	Assert.assertEquals(s2,s1);
	String date = driver.findElement(By.xpath("//div[@class='f1'/table/tbody/tr[1]/td/table/tbody/tr[3]/td[1]")).getText();
	
	}
}
	
