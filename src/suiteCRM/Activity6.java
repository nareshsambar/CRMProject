package suiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity6 {
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
	public void activityTest6() {
		System.out.println("ActivityTest6");
		Reporter.log("Test 6 Started");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		boolean suitecrmdashboard=driver.findElement(By.id("tab0")).isDisplayed();
		if (suitecrmdashboard) {
			System.out.println("Suite CRM Homepage is opened");
			Reporter.log("Suite CRM Homepage is opened");
		}
		else {
			System.out.println("Suite CRM Homepage is not opened");
		}
		String activitiesMenuText=driver.findElement(By.id("grouptab_3")).getText();
		Assert.assertEquals("ACTIVITIES", activitiesMenuText);
		System.out.println("Menu Exists "+activitiesMenuText);
		Reporter.log("Menu Exists "+activitiesMenuText);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		Reporter.log("AfterMethod");
		driver.close();
	}
	
}
