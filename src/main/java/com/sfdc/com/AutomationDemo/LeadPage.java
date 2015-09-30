package com.sfdc.com.AutomationDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sfdc.com.AutomationDemo.Utilities.ReadPropertiesData;
import com.sfdc.com.utilities.ReadDataFromExcel;

public class LeadPage extends commonPages {

	LeadModel lead = new LeadModel();
	ReadPropertiesData read = new ReadPropertiesData();
	ReadDataFromExcel readExcel = new ReadDataFromExcel();
	
	public By linkText  = By.linkText("Leads");
	public By  newButton = By.name("new");
	public By recordTypes = By.id("p3");
	public By continueButton   = By.xpath("//input[@value='Continue']");
	public Integer TimeSec = 10;
	

	public LeadPage() throws Exception{
		
		
	}
	public void gotoLeadPage(WebDriver driver) throws InterruptedException{
		driver.findElement(linkText).click();
		Thread.sleep(1000);
		driver.findElement(newButton).click();
		implicitWait(driver,TimeSec);
		Select options = new Select(driver.findElement(recordTypes));
		//options.selectByVisibleText(lead.recordTypeOfNewRecord[2]);
		options.selectByIndex(1);
		options.selectByVisibleText(LeadModel.recordType.EMEASALES.toString());
		//TODO: Write a locator for continue button using xpath
		driver.findElement(continueButton).click();
		implicitWait(driver,TimeSec);
		
			
	}
	
	public void gotoLeadPage(WebDriver driver, String recordType) throws InterruptedException{
		driver.findElement(linkText).click();
		Thread.sleep(1000);
		driver.findElement(newButton).click();
		implicitWait(driver,TimeSec);
		Select options = new Select(driver.findElement(recordTypes));
		//options.selectByVisibleText(lead.recordTypeOfNewRecord[2]);
		options.selectByVisibleText(recordType);
		//TODO: Write a locator for continue button using xpath
		driver.findElement(continueButton).click();
		implicitWait(driver,TimeSec);
			
	}
	public void gotoLeadPageAndCreateWebToLead(WebDriver driver) throws InterruptedException{
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("new")).click();
		implicitWait(driver,10);
		Select options = new Select(driver.findElement(By.id("p3")));
		//options.selectByVisibleText(lead.recordTypeOfNewRecord[2]);
		options.selectByIndex(2);
		//TODO: Write a locator for continue button using xpath
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		implicitWait(driver,10);
			
	}
	
	public void createLead(WebDriver driver) throws IOException{
		ReadDataFromExcel readExcel = new ReadDataFromExcel();
		driver.findElement(By.name("name_lastlea2")).sendKeys(readExcel.retrieveValueFromExcel(1, 0));
		driver.findElement(By.name("lea3")).sendKeys(lead.company);
		driver.findElement(By.name("00N500000031lEz")).sendKeys(lead.altPhone);
		/*This is Select Class used for dropdown option in webapplication */
		Select options = new Select(driver.findElement(By.id("lea13")));
		options.deselectByVisibleText(lead.leadStatus[0]);
		driver.findElement(By.name("save")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*This is identifying all the fields and values in the section  */              
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@class='detailList']/tbody/tr"));
	   for(int i=0;i<tableData.size();i++){
		   
		System.out.println(tableData.get(i).getAttribute("id")); 
	   }	    
		
	}
	
	public void createLead(WebDriver driver,String recordType) throws IOException{
		ReadDataFromExcel readExcel = new ReadDataFromExcel();
		driver.findElement(By.name("name_lastlea2")).sendKeys(readExcel.retrieveValueFromExcel(1, 0));
		driver.findElement(By.name("lea3")).sendKeys(lead.company);
		driver.findElement(By.name("00N500000031lEz")).sendKeys(lead.altPhone);
		/*This is Select Class used for dropdown option in webapplication */
		Select options = new Select(driver.findElement(By.id("lea13")));
		options.deselectByVisibleText(lead.leadStatus[0]);
		driver.findElement(By.name("save")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*This is identifying all the fields and values in the section  */              
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@class='detailList']/tbody/tr"));
	   for(int i=0;i<tableData.size();i++){
		   
		System.out.println(tableData.get(i).getAttribute("id")); 
	   }	    
		
	}
	
	
	
	public void findAllIDs(WebDriver driver){
		List<WebElement> allIDs = driver.findElements(By.tagName("input"));
		for(int i=0;i<allIDs.size();i++){
		System.out.println(allIDs.get(i));
		}
	}
	
	public boolean searchSalesforceLogo(WebDriver driver){
		//driver.switchTo().frame(driver.findElement(By.id("chat_widget_frame")));
		 return driver.findElement(By.linkText("Infomerica Inc Internal")).isDisplayed();
	}
	
	public void switchTabs(WebDriver driver){
		String Tab1 = driver.getWindowHandle(); 
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles()); 
		if (!availableWindows.isEmpty()) { 
			driver.switchTo().window(availableWindows.get(1)); 
			System.out.println(driver.getCurrentUrl());
			driver.switchTo().window(Tab1);
		}
		//driver.switchTo().window(tabs.get(1));
	}
	
	public void switchTabs1(WebDriver driver){
		String Tab1 = driver.getWindowHandle(); 
		LinkedHashSet<String> availableWindows = (LinkedHashSet<String>) driver.getWindowHandles(); 
		if (!availableWindows.equals(Tab1)) { 
			driver.switchTo().window(availableWindows.toString()); 
			System.out.println(driver.getCurrentUrl());
			driver.switchTo().window(Tab1);
		}
		//driver.switchTo().window(tabs.get(1));
	}
	
	
	
	public String getLeadName(WebDriver driver){
		
		/*This is identifying all the fields and values in the section  */              
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@class='detailList']/tbody/tr[2]/td[2]"));
	    return tableData.get(0).getText();		
	}
	
	public boolean verifyCreatedLead(WebDriver driver){
		return driver.findElement(By.className("pageDescription")).isDisplayed();
	}
	
	public void deleteLead(WebDriver driver){
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		
	}
	public void searchLead(WebDriver driver, String leadName){
		driver.findElement(By.id("phSearchInput")).sendKeys(leadName);
		driver.findElement(By.id("phSearchButton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public String verifyNoRecordsFound(WebDriver driver){
		return driver.findElement(By.id("searchResultsWarningMessageBox")).getText();
	}
	
	public void uiliTags(WebDriver driver) throws InterruptedException{
		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(By.id("")));
		actions.moveToElement(driver.findElement(By.linkText("Alerts"))).sendKeys("ENTER");
		Thread.sleep(1000);
		
	}
	
	public void javaScriptExecutor(){
	
	}
	
	public void windowHandlers(WebDriver driver){
		/* This is to get current window         */
		String handle = driver.getWindowHandle();
		driver.switchTo().window(handle);
		
	}
	
	public void alertsMethod(WebDriver driver){
		Alert alerts = driver.switchTo().alert();
		
	}
	
	public void framesDriver(WebDriver driver){
		System.out.println(driver.getPageSource());
		driver.switchTo().frame(0);
	}
	
}
