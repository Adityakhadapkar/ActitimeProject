package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

public class TaskTest extends BaseClass
{
	@Test
	public void creatCustomer() throws EncryptedDocumentException, IOException {
		
		HomePage hp=new HomePage(driver);
		hp.getTasklnk().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		FileLibrary f=new FileLibrary();
		String name = f.readDataFromExcel("Sheet1", 3, 1);
		tp.getCustname().sendKeys(name);
		String description = f.readDataFromExcel("Sheet1",3, 2);
		tp.getCustdesp().sendKeys(description);
		tp.getCreatecust().click();
	}

}