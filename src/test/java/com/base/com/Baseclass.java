package com.base.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static void SetProperty() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lavan\\eclipse-workspace\\SeleniumSample\\exefile\\chromedriver.exe");
//		Baseclass.SetProperty("webdriver.chrome.driver", "C:\\Users\\Lavan\\eclipse-workspace\\SeleniumSample\\exefile\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}


	public static String reusableProp(String key) throws IOException {

		FileReader file = new FileReader(
				"C:\\Users\\Lavan\\eclipse-workspace\\SampleMaven\\src\\test\\resources\\Lavanya\\PropertySampleFile.properties");
		Properties prop = new Properties();

		prop.load(file);
		String value = prop.getProperty(key);

		return value;

	}

	public static void url(String url) {
		driver.get(url);
	}

	public static WebElement findElementById(String ID) {
		return driver.findElement(By.id(ID));
	}

	public static WebElement findElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement findElementLinkText(String LinkText) {
		return driver.findElement(By.linkText(LinkText));
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String getText(WebElement element) {
		return element.getText();
	}

	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void dropDownIndex(WebElement element, int index) {

		Select options = new Select(element);
		options.selectByIndex(index);

	}

	public static void dropDownvalue(WebElement element, String index) {

		Select options = new Select(element);
		options.selectByValue(index);
	}

	public static void dropDownvisibleText(WebElement element, String index) {

		Select options = new Select(element);
		options.selectByValue(index);
	}

//	public static String excelHandle(int row1, int cell1) throws IOException {
//		String value = null;
//		File f = new File(
//				"C:\\Users\\Lavan\\eclipse-workspace\\SampleMaven\\src\\test\\resources\\Lavanya\\Excel\\data.xlsx");
//		FileInputStream fis = new FileInputStream(f);
//		Workbook wb = new Workbook(fis);
//		Sheet sh = wb.getSheet("Sheet1");
//		Row row = sh.getRow(row1);
//		Cell cell = row.getCell(cell1);
//		int cellType = cell.getCellType();
//		if (cellType == 1) {
//			value = cell.getStringCellValue();
//
//		} else if (cellType == 0) {
//
//			if (DateUtil.isCellDateFormatted(cell)) {
//				Date dateCellValue = cell.getDateCellValue();
//
//				SimpleDateFormat sc = new SimpleDateFormat("dd/MM/yyyy");
//				value = sc.format(dateCellValue);
//			} else {
//				double numericCellValue = cell.getNumericCellValue();
//
//				long a = (long) numericCellValue;
//				value = String.valueOf(a);
//
//			}
//		}
//
//		return value;

	// }

//	public static void orderNumberWrite() throws IOException {
//		WebElement OrderNumber = driver.findElement(By.xpath("//input[@id='order_no']"));
//		String number = OrderNumber.getAttribute("Value");
//		System.out.println(number);
//		File f = new File(
//				"C:\\Users\\Lavan\\eclipse-workspace\\SampleMaven\\src\\test\\resources\\Lavanya\\Excel\\data.xlsx");
//		FileInputStream fis = new FileInputStream(f);
//		Workbook wb = new Workbook(fis);
//		Sheet sh = wb.createSheet("Output");
//		Row row = sh.createRow(0);
//		Cell cell = row.createCell(0);
//		cell.setCellValue(number);
//		FileOutputStream fos = new FileOutputStream(f);
//		wb.write(fos);
//		wb.close();
//	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static String getAttribute(WebElement element, String value) {
		return element.getAttribute(value);

	}

	public static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

}
