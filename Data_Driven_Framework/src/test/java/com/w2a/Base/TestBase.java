package com.w2a.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;



public class TestBase 
{
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static WebElement dropdown;
	
	@BeforeSuite
	public void setUp()
	{
		if(driver==null)
		
	try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			config.load(fis);
			log.debug("config file is loaded...!!");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			OR.load(fis);
			log.debug("OR file is loaded..!!");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		if(config.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
			log.debug("chrome launched..!!");
			driver=new ChromeDriver();
		}
		
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		
		wait=new WebDriverWait(driver, 10);
}
		
	
	
	public void click(String locators)
	{
		driver.findElement(By.cssSelector(OR.getProperty(locators))).click();
	}
	
	public void type(String locator ,String value)
	{
	
		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
	
	}
		
	
	
	public void select(String locator,String value)
	{
		dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
	
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);

		
}
	
		

	
	
	
	public boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
			
		}
		catch(NoSuchElementException e)
		{
			return false;
			
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null) {
			
	driver.quit();
		}
		log.debug("Test execution is completed..!!");
		
	}

}
