package com.Itlearn.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExelFile {
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue (String fileName, String sheetName, int rowNumber, int columnNumber ) {
		try {
			fis=new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			cell = sheet.getRow(rowNumber).getCell(columnNumber);
			
			workbook.close();
			
			return cell.getStringCellValue();
			
		} 
		catch (Exception e) {
			
			return " ";
		}
	
		
	}
	
	public static int getRowCount (String fileName, String sheetName) {
		try {
			fis=new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			int row = sheet.getLastRowNum()+1;
			
			
			workbook.close();
			
			return row;
			
		} 
		catch (Exception e) {
			
			return 0;
		}
		
	}
	public static int getColumnCount (String fileName, String sheetName) {
		try {
			fis=new FileInputStream(fileName);
			//workbook = new XSSFWorkbook(fis);
			//sheet = workbook.getSheet(sheetName);
			//int column = sheet.getRow(0).getLastCellNum();
			
			workbook= new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			
			//get total no. of column 
			int ttlCells= sheet.getRow(1).getLastCellNum();
			
			workbook.close();
			
			return ttlCells;
			
			
		} 
		catch (Exception e) {
			
			return 0;
		}
		
	}
	public String getStringData(int sheetIndex,int row,int column)
	{
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column)
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row,int column)
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	

}
