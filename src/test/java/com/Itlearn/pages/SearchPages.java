package com.Itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPages {
	WebDriver driver;

	public SearchPages(WebDriver driver1) 
	{
		this.driver = driver1;

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_course") WebElement srchCourse;

	@FindBy(xpath = "//*[@id=\"primary_menu\"]/nav[1]/form/button")WebElement searchbutton;

	public void searchCourse() {

		srchCourse.sendKeys("selenium");

		searchbutton.click();

	}
}
