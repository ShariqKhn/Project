package com.w2a.utilities;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.DataProvider;

import com.w2a.Base.TestBase;

public class TestUtil extends TestBase
{
	public static String screenshotpath;
	public static String screenshotname;
	
	public static void captureScreenshot() throws Exception
	{
	
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	screenshotname="error.jpg";
	
    FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotname));
	
    
	
	}
	
	
	
	
	
	@DataProvider(name="dp")
	public String[][] getData()
	{
		String data[][]= {
					{"Amir","khan","208001","Customer added successfully"},
					{"Adnan","khan","110092","Customer added successfully"}
					//{"Arsalan","khan","208920","Customer added successfully"},
					//{"Mohd","Arham","208001","Customer added successfully"}
					
			};
		
		return data;
	}
	
		@DataProvider(name="op")
		public String[][] getData1()
		{
			String data[][]= {
					{"Amir khan","Rupee","Account created successfully"}
			};
			
			return data;
			
		}
	
	/*@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows][cols];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}*/
	

}
