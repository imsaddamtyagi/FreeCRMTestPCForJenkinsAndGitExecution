package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{

	public static long PAGE_LOAD_TIMEOUT=50;
	public static long IMPLICIT_WAIT = 50;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\Sofiya\\git\\FreeCRMTestPC\\FreeCRMTestPC\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void awitchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		
		try
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			try {
				book = WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
			sheet = book.getSheet(sheetName);
			Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)					
						{
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
					
						}
			}
			
			return data;				
	}

	
	
	
	
}
