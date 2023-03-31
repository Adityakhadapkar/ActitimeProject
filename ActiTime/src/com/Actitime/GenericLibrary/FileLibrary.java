package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is a generic class which having method for data driven testing
 * @author Aditya
 */

public class FileLibrary {
	
	public String readDataFromProperty (String key) throws IOException {
		
		FileInputStream fis= new FileInputStream("./TestData/commondata.property");
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * this method is a non static method used to read the data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @throws EncryptedDocumentException 
	 */
	public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException{
		FileInputStream fis1=new FileInputStream("./TestData/ActitimeTestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
}