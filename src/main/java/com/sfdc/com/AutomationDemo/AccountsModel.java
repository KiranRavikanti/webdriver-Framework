package com.sfdc.com.AutomationDemo;

public class AccountsModel {
	public static String accountName = "Delta Information Systems";
	public static String slaExpirationDate = "11/09/2015";
	public static String active[] = {"Yes","No"};
	public static String sla[] ={"Gold","Silver","Platinum","Bronze"};
    public static String slaSerialNumber = "0123456789";
	public static String getAccountName() {
		return accountName;
	}
	public static void setAccountName(String accountName) {
		AccountsModel.accountName = accountName;
	}
	public static String getSlaExpirationDate() {
		return slaExpirationDate;
	}
	public static void setSlaExpirationDate(String slaExpirationDate) {
		AccountsModel.slaExpirationDate = slaExpirationDate;
	}
	public static String[] getActive() {
		return active;
	}
	public static void setActive(String[] active) {
		AccountsModel.active = active;
	}
	public static String[] getSla() {
		return sla;
	}
	public static void setSla(String[] sla) {
		AccountsModel.sla = sla;
	}
	public static String getSlaSerialNumber() {
		return slaSerialNumber;
	}
	public static void setSlaSerialNumber(String slaSerialNumber) {
		AccountsModel.slaSerialNumber = slaSerialNumber;
	}
    
}
