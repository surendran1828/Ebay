package org.ebay;

import org.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageclass extends Base {
	public Pageclass() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@type='text']")
	private static WebElement searchbar;
	
	@FindBy(xpath="//input[@type='submit']")
	private static WebElement search;
	
	public void searchbar(String arg0) {
		searchbar.sendKeys(arg0);
		
	}
	
	public void search() {
		search.click();
		
	}
	

}
