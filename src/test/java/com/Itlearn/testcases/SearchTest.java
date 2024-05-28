package com.Itlearn.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Itlearn.pages.BaseClass;
import com.Itlearn.pages.LoginPage;
import com.Itlearn.pages.SearchPages;
import com.Itlearn.utilities.ListenersClass;

@Listeners(ListenersClass.class)
public class SearchTest extends BaseClass {
	
	@Test
	public void searchCourse () 
	{
	lp = new LoginPage (driver);	 
	lp.loginPortal(username, password);
	SearchPages sp = new SearchPages (driver);
    sp.searchCourse(); 

	}	

}
