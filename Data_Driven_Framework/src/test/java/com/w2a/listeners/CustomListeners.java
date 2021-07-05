package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.w2a.utilities.TestUtil;

public class CustomListeners implements ITestListener 
{

	public void onTestStart(ITestResult result) 
	{
		
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		
		
	}

	public void onTestFailure(ITestResult result) 
	{
		try {
			TestUtil.captureScreenshot();
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
			e.getMessage();
			e.getCause();
		}
		
		Reporter.log("Capturing screenshot");
		Reporter.log("< a target=\"_blank\" href="+TestUtil.screenshotname+">Screenshot</a>");
		Reporter.log("<br>");
		//Reporter.log("<a target=\"_blank\"href=);
		
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}

	public void onStart(ITestContext context) 
	{
		
		
	}

	public void onFinish(ITestContext context)
	{
		
		
	}
	

}
