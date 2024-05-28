package com.Itlearn.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.Itlearn.utilities.BrowserFactory;
import com.Itlearn.utilities.ConfigDataProvider;
import com.Itlearn.utilities.ReadExelFile;

public class BaseClass {
	String filename= System.getProperty("user.dir")+"\\TestData\\data.xlsx";
	
	public WebDriver driver;
	public ConfigDataProvider conf = new ConfigDataProvider();
	public ReadExelFile rf = new ReadExelFile ();
    public LoginPage lp ;
    public String username = ReadExelFile.getCellValue(filename, "Sheet1", 1, 0);
    public String password = ReadExelFile.getCellValue(filename, "Sheet1", 1, 1);
	
	
	
	
	
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startApplication(driver, conf.getBrowser(), conf.getUrl());
	}
	public static void captureScreenShot(WebDriver driver,String testName) throws IOException 
	 {
		 // Convert webdriver object to TakesScreenshot interface
		 TakesScreenshot screenshot= ((TakesScreenshot)driver);
		 
		 // Step 2 :call getScreenshotAs method to capture image file
		 
		 File src= screenshot.getScreenshotAs(OutputType.FILE);
		 File srcpath=new File("."+"//ScreenShot//"+ testName + ".png");
		 System.out.println("This is screenshot section");

		 // Step 3 : copy image file to destination 
		 FileUtils.copyFile(src, srcpath);
	 }
}
