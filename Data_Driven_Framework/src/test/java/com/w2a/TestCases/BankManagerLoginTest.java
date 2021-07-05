package com.w2a.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.Base.TestBase;

public class BankManagerLoginTest extends TestBase
{
	
	@Test
	public void loginAsBankManager() throws Exception
	{
		log.debug("Inside LoginTest");
		click("bmlBtn_CSS");
		//driver.findElement(By.cssSelector(OR.getProperty("bmlBtn_CSS"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustbtn"))),"Login Not sucessfull..!!");
		
		log.debug("LoginTest is sucessfully exceuted..!!");
		Reporter.log("LoginTest is sucessfully exceuted..!!");
		
		
	}

}
