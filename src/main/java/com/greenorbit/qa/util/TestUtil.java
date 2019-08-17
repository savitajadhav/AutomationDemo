package com.greenorbit.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.TextUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.greenorbit.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT = 10;	
    public static String TESTDATA_SHEET_PATH = "D:\\JavaProgram\\GreenOrbitTest\\src\\main\\java\\com\\greenorbit\\qa\\testdata\\TestData.xlsx";
    
    
    public static void switchToFrame(String id)
    {
    	driver.switchTo().parentFrame();
    	driver.switchTo().frame(id);
    	System.out.println("Switched to frame: " +id);
    }
    
	public static void takeScreenshotAtEndOfTest() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static Object[][] getTestData(String sheetName) throws Exception{
		FileInputStream file = null;
		try {
			 file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
			
		  XSSFWorkbook book = new XSSFWorkbook(file);
		  XSSFSheet sheet = book.getSheet(sheetName);
		/*  System.out.println("SheetName:" +sheetName);
		  int rowcnt = sheet.getLastRowNum();
		  System.out.println("Row Count:"+rowcnt);
		  int colcnt = sheet.getRow(0).getLastCellNum();
		  System.out.println("Column count:"+colcnt); */
		  Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		  for(int row=0; row<sheet.getLastRowNum(); row++){
			  for(int col=0; col<sheet.getRow(0).getLastCellNum(); col++){
				  data[row][col] = sheet.getRow(row+1).getCell(col).toString();
				  System.out.println(data[row][col]);
			  }
		  }
	    return data;
	}
	
	

}

