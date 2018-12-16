package com.seleniumassignment.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountInformation {
	
	WebDriver driver = new ChromeDriver();
	int[] arr = new int[9];
	
	public void display(){
		System.out.println(arr[0]);
	}

}
