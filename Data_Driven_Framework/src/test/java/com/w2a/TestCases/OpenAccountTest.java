package com.w2a.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.Base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase
{
	@Test(dataProviderClass=TestUtil.class,dataProvider="op")
	public void openAccountTest(String Customer,String Currency,String alerttext) throws Exception
	{
		System.out.println(Customer + " "+Currency);
		
		click("openaccount");
		select("customer",Customer);
		select("currency", Currency);
		click("process");
		 
		Thread.sleep(3000);
		Alert aleart= wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(aleart.getText().contains(alerttext));
		aleart.accept();
		
		Thread.sleep(2000);
		
		   
		
	}

}
