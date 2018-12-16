package com.seleniumassignment.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.seleniumassignment.qa.utils.TestUtil;
import com.seleniumassignment.qa.utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase(){
	
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\eclipse-java-luna-SR2-win32-x86_64\\eclipse\\workspace\\SeleniumAssignment\\src\\main\\java\\com\\seleniumassignment\\qa\\config\\config.properties");
		prop.load(ip);		
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void initialization(){
		
		System.out.println(prop.getProperty("browser"));
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")){

			System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		//	System.setProperty("webdriver.chrome.driver","D:\\eclipse-java-luna-SR2-win32-x86_64\\eclipse\\workspace\\SeleniumAssignment\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		else if(browser.equals("ie")){
			driver = new InternetExplorerDriver();
		}

		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("url"));
		driver.manage().window().maximize() ;
		System.out.println(driver.getTitle());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.page_load_timeout, TimeUnit.SECONDS);

		
}
}
