package suiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity2{
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
		Reporter.log("Before Method");
		System.setProperty("webdriver.chrome.driver", "C://Selenium//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}
	
	@Test
	public void activityTest2() {
		System.out.println("ActivityTest2");
		Reporter.log("Test 2 Started");
		String headerImageURL=driver.findElement(By.xpath("//a[@title='SuiteCRM']")).getAttribute("href");
		Assert.assertEquals("http://www.suitecrm.com/", headerImageURL);
		System.out.println(" url of the header image : "+headerImageURL);
		Reporter.log(" url of the header image : "+headerImageURL);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		Reporter.log("After Method");
		driver.close();
	}
}
