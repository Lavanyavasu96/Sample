package org.dataprovidersample.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.com.Baseclass;

public class DataProviderExe extends DataProviderLocatorsPage {

	
	@BeforeClass
	public void Launch() {
		SetProperty();
		url("https://opensource-demo.orangehrmlive.com/");
	}
	@DataProvider(name = "Data")
	public String[][] excelDataProvider() throws IOException {

		File f = new File("C:\\Users\\Lavan\\OneDrive\\Desktop\\data.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int noofRows = sheet.getPhysicalNumberOfRows();
		int noOfColoumn = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[noofRows - 1][noOfColoumn];
		for (int i = 0; i < noofRows - 1; i++) {
			for (int j = 0; j < noOfColoumn; j++) {

				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i ).getCell(j));

			}

		}
		return data;

	}

//	@DataProvider(name = "Data")
//	public String[][] dataProvider() {
//		String[][] loginDatas = { { "lavanya", "Welcome@123" }, { "lavan", "Welcome@12345" }, { "lav", "Welcom" } };
//
//		return loginDatas;
//
//	}
	

	@Test(dataProvider = "Data")
	public void Test1(String user, String pass) {

		sendKeys(findElementByXpath(DataProviderLocatorsPage.usernameXpath), user);
		sendKeys(findElementByXpath(DataProviderLocatorsPage.passwordXpath), pass);
		Baseclass.click(Baseclass.findElementByXpath(DataProviderLocatorsPage.loginButton));
		System.out.println("login tried");
	}

}
