package com.sfdc.com.AutomationDemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfdc.com.AutomationDemo.Utilities.ReadDataFromExcel;
@Test
public class TestClass {
    
	WebDriver driver; 
	//@BeforeMethod(groups={"Functional Tests","Smoke Tests"})
	public void openSFDC(){
		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	//@Test(groups={"Functional Tests","Regression Tests"})
	public void testLeadPage() throws Exception{
		LoginPage loginpage = new LoginPage();
		loginpage.loginToSFDC(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LeadPage lead = new LeadPage();
		lead.gotoLeadPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 lead.createLead(driver);
		 String leadName = lead.getLeadName(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(lead.verifyCreatedLead(driver));
		Assert.assertTrue(lead.searchSalesforceLogo(driver));
		lead.deleteLead(driver);
		driver.findElement(By.linkText("Terms of Use")).click();
		lead.switchTabs(driver);
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lead.searchLead(driver,leadName);
		Assert.assertEquals(lead.verifyNoRecordsFound(driver), "No matches found");
		long id = Thread.currentThread().getId();
		System.out.println("This thread is" + id);	
	}
	/*This is multithreading by individual method */
	@Test(threadPoolSize = 3, invocationCount = 6, timeOut = 1000)
	public void testExcelDataRetrieval() throws IOException{
		ReadDataFromExcel data = new ReadDataFromExcel();
		
		System.out.println(data.retrieveValueFromExcel(1, 0));
		System.out.println(data.retrieveValueFromExcel(2, 0));
		System.out.println(data.retrieveValueFromExcel(3, 0));
		long id = Thread.currentThread().getId();
		System.out.println("This is the id of thread" + id);
		
	}
	
	
	
	

}
