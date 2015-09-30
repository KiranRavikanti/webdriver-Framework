package com.sfdc.com.AutomationDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.sfdc.com.AutomationDemo.Utilities.ReadDataFromExcel;
import com.sfdc.com.AutomationDemo.Utilities.ReadPropertiesData;
public class LeadTest  {
  WebDriver driver;
	
	
	@BeforeMethod(groups={"Functional Tests","Smoke Tests"})
	public void openSFDC(){
		driver= new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("This runs at every method");
	}
	@BeforeTest
	public void runBeforeClass(){
		driver.manage().deleteAllCookies();	
		System.out.println("Successfully the cookies are deleted");
	}
	
	//@Test(priority=1)
	public void testLogin(){
		LoginPage loginpage = new LoginPage();
		loginpage.loginToSFDC(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.verifyLogin(driver);
	}
	//@Test(groups={"Functional Tests"},priority=2)
	public void testLeadPage() throws Exception{
		LoginPage loginpage = new LoginPage();
		loginpage.loginToSFDC(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.verifyLogin(driver);
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
		lead.switchTabs1(driver);
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lead.searchLead(driver,leadName);
		Assert.assertEquals(lead.verifyNoRecordsFound(driver), "No matches found");
		long id = Thread.currentThread().getId();
		System.out.println("This thread is" + id);	
	}
	//@Test(dependsOnMethods={"testLeadPage"}, alwaysRun=true)
	public void displayPropertyData(){
		ReadPropertiesData read = new ReadPropertiesData();
		System.out.println(read.getPropertyValue("LeadName"));
        Set<Object> keys = read.getAllKeys();
        for(Object k:keys){
            String key = (String)k;
            System.out.println(key+": "+read.getPropertyValue(key));
        }
		
	}
	
	//@Test(groups = {"Smoke Tests"},priority=1)
	public void testAccountsPage(){
		LoginPage loginpage = new LoginPage();
		loginpage.loginToSFDC(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AccountsPage acc = new AccountsPage();
		acc.gotoAccounts(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		acc.createAccounts(driver);
		String accName = acc.getAccountName(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(acc.verifyCreatedAccount(driver));
		acc.deleteAccount(driver);
        acc.searchAccount(driver, accName);
        Assert.assertEquals(acc.verifyNoRecordsFound(driver), "Documents (1)");


       
	}
	//@AfterMethod
	public void closeBrowser(){
		driver.quit();
		System.out.println("This browser is closed");
	}
	

}
