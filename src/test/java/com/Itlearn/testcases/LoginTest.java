package com.Itlearn.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Itlearn.pages.BaseClass;
import com.Itlearn.pages.LoginPage;
import com.Itlearn.utilities.ReadExelFile;

public class LoginTest extends BaseClass{
	String filename= System.getProperty("user.dir")+"\\TestData\\data.xlsx";
	@Test(dataProvider="loginData")
	public void verifyLoging (String username,String password) throws IOException {
		LoginPage lp= new LoginPage(driver);
		lp.loginPortal(username, password);
		if(username.equals("Demo12") && password.equals("Test123456$"))
		{
			
		
		Assert.assertTrue(true);
		lp.logout();
		}
		else
		{
			captureScreenShot(driver,"verifyLoging");
			Assert.assertTrue(false);
		}
		
		
	}
	@DataProvider
	public String[][] loginData () {
	
		int ttlRows= ReadExelFile.getRowCount(filename, "Sheet1");
		int ttlColumns= ReadExelFile.getColumnCount(filename, "Sheet1");
		
		System.out.println(ttlRows);
		System.out.println(ttlColumns);
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExelFile.getCellValue(filename, "Sheet1", i, j);
			}
		}
		return data;
		
	}
}
