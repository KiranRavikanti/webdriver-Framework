package com.sfdc.com.AutomationDemo;

import java.io.IOException;
import java.util.EnumMap;

import com.sfdc.com.AutomationDemo.Utilities.ReadPropertiesData;
import com.sfdc.com.utilities.ReadDataFromExcel;

public class LeadModel {
	   
   ReadDataFromExcel readExcel = new ReadDataFromExcel();
	
	public static String lastName ="XYZ1890";
	public static String company = "SFDC";
	public static String altPhone = "4023044639";
	public  String recordTypeOfNewRecord[] = {"EMEASales","PremiumCustomers","WebtoLead"};
	public enum recordType{
				EMEASALES("EMEASales"), 
				PREMIUMCUSTOMERS("PremiumCustomers"),
				WEBTOLEAD("WebToLead");
		private final String label;
	    
		private recordType(String label) {
	        this.label = label;
	    }
	    public String toString() {
	        return this.label;
	    }
	}
	public static String iframe = "This is Lead Description";
	public String[] getRecordTypeOfNewRecord() {
		return recordTypeOfNewRecord;
	}
	public void setRecordTypeOfNewRecord(String[] recordTypeOfNewRecord) {
		this.recordTypeOfNewRecord = recordTypeOfNewRecord;
	}
	public static String getIframe() {
		return iframe;
	}
	public static void setIframe(String iframe) {
		LeadModel.iframe = iframe;
	}
	public static String getLastName() {
		return lastName;
	}
	public static void setLastName(String lastName) {
		LeadModel.lastName = lastName;
	}
	public static String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		LeadModel.company = company;
	}
	public static String getAltPhone() {
		return altPhone;
	}
	public static void setAltPhone(String altPhone) {
		LeadModel.altPhone = altPhone;
	}
	public static String[] getLeadStatus() {
		return leadStatus;
	}
	public static void setLeadStatus(String[] leadStatus) {
		LeadModel.leadStatus = leadStatus;
	}
	public static String leadStatus[] = {"OpenNot-Contacted","Working-Contacted","Closed-Converted","Closed-NotConverted"};
	
	

}
