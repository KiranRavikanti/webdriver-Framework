package com.sfdc.com.AutomationDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class commonPages {
	
	public void implicitWait(WebDriver driver, int timeSec){
		driver.manage().timeouts().implicitlyWait(timeSec, TimeUnit.SECONDS);
	}

}
