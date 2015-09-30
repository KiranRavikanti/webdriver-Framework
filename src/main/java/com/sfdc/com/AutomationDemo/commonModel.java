package com.sfdc.com.AutomationDemo;

import com.sfdc.com.AutomationDemo.Utilities.ReadDataFromExcel;
import com.sfdc.com.AutomationDemo.Utilities.ReadPropertiesData;

public class commonModel {
	static ReadPropertiesData read = new ReadPropertiesData();
	
	public static String read(String Key){
		return read.getPropertyValue(Key);
	}
	
	
	

}
