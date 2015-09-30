package com.sfdc.com.AutomationDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountsPage {
AccountsModel model = new AccountsModel();
public void gotoAccounts(WebDriver driver){
	driver.findElement(By.xpath("//a[@title='Accounts Tab']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("new")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void createAccounts(WebDriver driver){
	

	Select options = new Select(driver.findElement(By.id("00N50000002EQxN")));
	options.selectByIndex(1);
	Select options1 = new Select(driver.findElement(By.id("00N50000002EQxQ")));
	options1.selectByIndex(1);
	driver.findElement(By.id("acc2")).sendKeys(model.accountName);
	driver.findElement(By.id( "00N50000002EQxS")).sendKeys(model.slaSerialNumber);
	driver.findElement(By.id("00N50000002EQxR")).sendKeys(model.slaExpirationDate);
	driver.findElement(By.name("save")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

public boolean verifyCreatedAccount(WebDriver driver){
	return driver.findElement(By.className("pageDescription")).isDisplayed();
}
public void deleteAccount(WebDriver driver){
	driver.findElement(By.xpath("//input[@value='Delete']")).click();
	Alert alert = driver.switchTo().alert();
	alert.getText();
	alert.accept();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void searchAccount(WebDriver driver, String accName){
	driver.findElement(By.id("phSearchInput")).sendKeys(accName);
	driver.findElement(By.id("phSearchButton")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
public String getAccountName(WebDriver driver){
	
	return driver.findElement(By.id("acc2_ileinner")).getText();
	
}
public String verifyNoRecordsFound(WebDriver driver){
	return driver.findElement(By.className("searchFirstCell")).getText();
}

}