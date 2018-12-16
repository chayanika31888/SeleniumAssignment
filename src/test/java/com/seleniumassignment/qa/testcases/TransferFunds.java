package com.seleniumassignment.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFunds {
	
	WebDriver driver = new ChromeDriver();
	
	@Test(dependsOnGroups="Login",description="TransferPageInformation")
	public void TransferPageDisplayed(){
		driver.get("http://demo.testfire.net/bank/account.aspx");
		driver.findElement(By.id("_ctl0__ctl0_Content_MenuHyperLink3")).click();
		String expectedTitle = "Altoro Mutual: Transfer Funds";
		String title = driver.getTitle();
		Assert.assertEquals(title, expectedTitle);
		
	}
	
	@Test(dependsOnGroups="Login",description="SelectFromAccount")
	public void TransferMoney(){
		Select debitAccount = new Select(driver.findElement(By.id("debitAccount")));
		debitAccount.selectByValue("1001160141");
		Select creditAccount = new Select(driver.findElement(By.id("creditAccount")));
		creditAccount.selectByValue("1001160141");
		driver.findElement(By.id("transferAmount")).sendKeys("testSelenium");
		driver.findElement(By.id("transfer")).click();
		
	}

}
