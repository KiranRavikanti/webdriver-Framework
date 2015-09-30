package com.sfdc.com.AutomationDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sfdc.com.utilities.ReadDataFromExcel;

public class LoginPage {
	LoginModel loginModel = new LoginModel();
	public void loginToSFDC(WebDriver driver){
	 driver.findElement(By.id("username")).sendKeys(loginModel.userName);
	 driver.findElement(By.id("password")).sendKeys(loginModel.passWord);
		driver.findElement(By.id("Login")).click();
		
	}
	public boolean verifyLogin(WebDriver driver){
	return	driver.findElement(By.linkText("Home")).isDisplayed();
		
		
		
	}


}
