package com.sfdc.com.AutomationDemo.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadDataFromExcel {
	FileInputStream fileInputStream;
	HSSFWorkbook workbook;
	HSSFSheet worksheet;
	HSSFRow row;
	HSSFCell cell;
	
		public void getExcelData(int rowNo, int cellNo) {
			try {
			    fileInputStream = new FileInputStream("LeadData.xls");
			    workbook = new HSSFWorkbook(fileInputStream);
			    worksheet = workbook.getSheet("LeadData");				
			    row = worksheet.getRow(rowNo);
				cell = row.getCell((short) cellNo);
				String cellValue = cell.getStringCellValue();	
				 System.out.println(cellValue);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void displayAllData(Integer rowCount, Integer cellCount) throws IOException{
			FileInputStream fileInputStream = new FileInputStream("ExcelData.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet("LeadData");
			for (int i=0;i<rowCount;i++){
				for (int j=0;i<cellCount;j++){
				HSSFRow row = worksheet.getRow(i);
				HSSFCell cell = row.getCell(j);
				String Value = cell.getStringCellValue();
				System.out.println(Value);
				}
			}
		}
		
			public String retrieveValueFromExcel(int rowIndex,int columnIndex) throws IOException{
		    fileInputStream  = new FileInputStream("LeadData.xls");
			workbook = new HSSFWorkbook(fileInputStream);
			worksheet = workbook.getSheet("LeadData");
			row = worksheet.getRow(rowIndex);
			cell = row.getCell(columnIndex);
		     String cellValue = cell.getStringCellValue();
		     return cellValue;
			
			}
		

	}


