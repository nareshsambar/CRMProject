package suiteCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity1{
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
		Reporter.log("Before Method");
		//System.setProperty("webdriver.gecko.driver", "C:/Selenium/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C://Selenium//Drivers//chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		//Open browser
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}
	
	@Test
	public void activityTest1() {
		System.out.println("ActivityTest1");
		Reporter.log("Test 1 Started");
		String actualURL=driver.getTitle();
		String expectedURL="SuiteCRM";
		Assert.assertEquals(expectedURL, actualURL);
		Reporter.log("URL of the loaded page : "+actualURL);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		Reporter.log("After Method");
		driver.close();
	}

}
