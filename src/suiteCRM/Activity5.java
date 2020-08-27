package suiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
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
	public void activityTest5() {
		System.out.println("ActivityTest5");
		Reporter.log("Test 5 Started");
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
		String navigationMenuColor=driver.findElement(By.id("toolbar")).getCssValue("color");
		System.out.println("Navigation Menu Color "+navigationMenuColor);
		Reporter.log("Navigation Menu Color "+navigationMenuColor);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		Reporter.log("After Method");
		driver.close();
	}
	
}
