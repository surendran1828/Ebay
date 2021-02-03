package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base { 
	public static WebDriver driver; 
	
	
	public static WebDriver launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suren\\eclipse-workspace\\Test\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	public static void launchurl(String url) {
		driver.get(url);
	}
	
	public static void fill(WebElement r,String s) {
		r.sendKeys(s);

	}
	public static void btnclick(WebElement c) {
	    c.click();	

	}
	public static String getAtt(WebElement g) {
		return g.getAttribute("value");
       
	}
	public static void setatt(WebElement s,String v) {
		s.sendKeys(v);
		

	}
	public static void mte(WebElement e) {	
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
		

	}
	public static void dad(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
		

	}
	public static void rclick(WebElement e) {
		Actions a=new Actions(driver);
		a.contextClick(e).perform();

	}
	public static void ddclick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();

	}
	public static void salart() {
		driver.switchTo().alert().accept();
		
	}
	public static void calart() {
		driver.switchTo().alert().dismiss();

	}
	public static void palart(String t) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(t);
		alert.accept();
	}
	public static void sbvi(WebElement e,int index) {
	 Select s=new Select(e);
	 s.selectByIndex(index);
		
	}
	public static void sbvt(WebElement e,String text) {
		Select s= new Select(e);
		s.selectByVisibleText(text);
		
	}
	public static void sbv(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
		
	}
	public static String getOption(WebElement e) {
		Select s=new Select(e);
		  String text=null;
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			   WebElement h = options.get(i);
			    text = h.getText();
		}
		return text;
		
	}
	public static void dsbi(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
		
	}
	public static void dsbvt(WebElement e,String text ) {
		Select s=new Select(e);
		s.deselectByVisibleText(text);
		
	}
	public static void dsbi(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
		
	}
	public static boolean isMultiple(WebElement e) {
		Select s=new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	public static void dsa(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
	}
	public static void gfso(WebElement e) {
		Select s=new Select(e);
		s.getFirstSelectedOption();
		
	}
	public static void insert(String s,WebElement w) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].setAttribute('value','s')", w);
		
	}
	public static void click(WebElement e) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click",e);

	}
	public static void jgetatt(WebElement e) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].getAttribute", e);
		
	}
	public static void jclick(WebElement e) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click()",e);
	}
	public static void sdown(WebElement e) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	public static void sup(WebElement e) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntroView(false)", e);
	
	}
	public static void screenShot(String pathname) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver; 
		File src=tk.getScreenshotAs(OutputType.FILE);
		File des=new File(pathname);
		FileUtils.copyFile(src, des);
			
			
		}
	public static String getExcelData(int row,int cell) throws IOException {
      File f=new File("C:\\Users\\suren\\eclipse-workspace\\Test\\src\\test\\resources\\Book1.xlsx");
      FileInputStream fl=new FileInputStream(f);
      Workbook w=new XSSFWorkbook(fl);
      Sheet sheet = w.getSheet("Sheet1");
      Row row2 = sheet.getRow(row);
      Cell cell2 = row2.getCell(cell);
      int cellType = cell2.getCellType();
      String value=null;
      if(cellType==1) {
    	  value = cell2.getStringCellValue();
      }
      else
      {
    	  if (DateUtil.isCellDateFormatted(cell2)) {
			Date date = cell2.getDateCellValue();
			SimpleDateFormat d=new SimpleDateFormat("dd-mm-yyyy");
			value = d.format(date);
		}
    	  else{
    		  double num = cell2.getNumericCellValue();
    		  long ln=(long) num;
    		  value =String.valueOf(ln);
    	  }  
	}
	return value;
	}
	public static void excelwrite(int row,int cell,String value) throws IOException {
		File f= new File("C:\\Users\\suren\\eclipse-workspace\\Test\\src\\test\\resources\\Book1.xlsx");
		Workbook w= new XSSFWorkbook();
		Sheet sh = w.createSheet("Sheet1");
		Row cRow = sh.createRow(row);
		Cell cCell = cRow.createCell(cell);
		cCell.setCellValue(value);
		FileOutputStream f1=new FileOutputStream(f);
		w.write(f1);
	}
	public static void excelEdit(int row,int cell,String name) throws IOException {
		File f=new File("C:\\Users\\suren\\eclipse-workspace\\Test\\src\\test\\resources\\Book1.xlsx");
		FileInputStream f1=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(f1);
		Sheet sheet = w.createSheet("Sheet1");
		Row row1 = sheet.getRow(row);
		Cell cell1 = row1.getCell(cell);
		cell1.getStringCellValue();
		cell1.setCellValue(name);
	}
}
	
	
	
	
	
	


