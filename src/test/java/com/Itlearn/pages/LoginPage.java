package com.Itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="loginlabel") WebElement loginClick;
	@FindBy(id="user_login") WebElement Username;
	@FindBy(id="user_pass") WebElement Password ;
	@FindBy(id="wp-submit") WebElement Login ;
	@FindBy(xpath="//*[@id=\"gk-login-toggle\"]/i") WebElement LogoutImage;
	@FindBy(xpath="//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a") WebElement Logout;
	
	public void loginPortal(String username,String password)
	{
		loginClick.click();
		Username.sendKeys(username);
		Password.sendKeys(password);
		Login.click();
	}
	public void logout () {
		LogoutImage.click();
		Logout.click();
	}
}
