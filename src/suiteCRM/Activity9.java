package suiteCRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
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
	public void activityTest9() throws InterruptedException {
		System.out.println("ActivityTest9");
		Reporter.log("Test 9 Started");
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
		Thread.sleep(4000);
		List<WebElement> table=driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
		int rowsSize=table.size();
		System.out.println("Number of rows in Table "+rowsSize);
		Reporter.log("Number of rows in Table "+rowsSize);
		for (int i=1;i<=10;i++) {
			String nameOfRow=driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[3]/b/a")).getText();
			System.out.println("Name of the "+i+"th row "+nameOfRow);
			Reporter.log("Name of the "+i+"th row "+nameOfRow);
			String userOfRow=driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[8]/a")).getText();
			System.out.println("User of the "+i+"th row "+userOfRow);
			Reporter.log("User of the "+i+"th row "+userOfRow);
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		Reporter.log("After Method");
		driver.close();
	}
	
}
