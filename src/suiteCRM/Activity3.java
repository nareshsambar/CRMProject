package suiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
	public void activityTest3() {
		System.out.println("ActivityTest3");
		Reporter.log("Test 3 Started");
		String firstCopyrightText=driver.findElement(By.id("admin_options")).getText();
		System.out.println("  first copyright text in the footer : "+firstCopyrightText);
		Reporter.log("  first copyright text in the footer : "+firstCopyrightText);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		Reporter.log("After Method");
		driver.close();
	}
}
