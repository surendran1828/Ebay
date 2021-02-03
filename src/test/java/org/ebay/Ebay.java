package org.ebay;

import java.util.List;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ebay extends Base {
	
	@BeforeClass
	private void beforeclass() {
		launchBrowser();
		launchurl("https://www.ebay.com/");
	
	}
	@Test
	private void test() {
		Pageclass p=new Pageclass();
		p.searchbar("iphone");
		p.search();
	}
	
	@Test
	private void test1() {
		List<WebElement> text = driver.findElements(By.xpath("//h3[@class='s-item__title s-item__title--has-tags']"));
		System.out.println(text.size());
		
		for (WebElement webElement : text) {
			String name =webElement.getText();
			System.out.println(name);
			
		}
	}
	
	@Test
	private void test2() {
		List<WebElement> text = driver.findElements(By.xpath("//span[@class='s-item__price']"));
		
		for (WebElement webElement : text) {
			String name =webElement.getText();
			System.out.println(name);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
