package suiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity7 {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
		Reporter.log("BeforeMethod");
		System.setProperty("webdriver.chrome.driver", "C://Selenium//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}

	@Test
	public void activityTest7() throws InterruptedException {
		System.out.println("ActivityTest7");
		Reporter.log("Test 7 Started");
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
		
		Actions actions = new Actions(driver);
		WebElement salesMenu=driver.findElement(By.id("grouptab_0"));
    	actions.moveToElement(salesMenu).perform();
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		Thread.sleep(2000);
		/*
		//to sort the table with date and time
		driver.findElement(By.xpath("(//a[@class='listViewThLinkS1'])[6]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='listViewThLinkS1'])[6]")).click();
		Thread.sleep(3000);
		*/
		driver.findElement(By.xpath("//tr[@class='oddListRowS1'][1]/td[10]")).click();
		Thread.sleep(5000);
		String phoneNumber=driver.findElement(By.xpath("//*[@id='ui-id-5']/span[@class='phone']")).getText();
		System.out.println("Phone Number "+phoneNumber);
		Assert.assertTrue(phoneNumber.length()==10);
		Reporter.log("Phone Number "+phoneNumber);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		Reporter.log("AfterMethod");
		driver.close();
	}
	
}
