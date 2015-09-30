package com.sfdc.com.AutomationDemo.Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
public class ReadPropertiesData {
	
private Properties prop = null;
public ReadPropertiesData(){
	FileReader  is = null;

try {
    this.prop = new Properties();
    is = new FileReader("Automation.properties");
    prop.load(is);
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
}


public Set<Object> getAllKeys(){
Set<Object> keys = prop.keySet();
return keys;
}

public String getPropertyValue(String key){
	return this.prop.getProperty(key);
	}
	

}
