package com.w2a.TestCases;

import org.openqa.selenium.Alert;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.w2a.Base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase
{
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomer(String firstName,String lastName,String postCode,String alerttext) throws InterruptedException
	{

		System.out.println(firstName +" "+lastName+" "+postCode);
		
		click("addCustbtn");
		Thread.sleep(3000);
		type("firstname",firstName);
		type("lastname",lastName);
		type("postcode", postCode);
		
		Thread.sleep(3000);
		
		click("addbtn");
		
		 Thread.sleep(3000);
	    
	   // Assert.fail("Can't Add customer");
	    
	   Alert aleart= wait.until(ExpectedConditions.alertIsPresent());
	   
	   Assert.assertTrue(aleart.getText().contains(alerttext));
	   
	   aleart.accept();
	   
	   Thread.sleep(3000);
	}
	
}
	
	
	
	
	
	


