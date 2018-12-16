package com.seleniumassignment.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.seleniumassignment.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long page_load_timeout = 20;
	public static long implicit_wait = 10;
	
	
	public static String TESTDATA_SHEET_PATH = "D:\\eclipse-java-luna-SR2-win32-x86_64\\eclipse\\workspace\\SeleniumAssignment\\src\\main\\java\\com\\seleniumassignment\\qa\\testdata\\testData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		
		try{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i< sheet.getLastRowNum(); i++){
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots" + System.currentTimeMillis() + ".png"));
		
	}

}
