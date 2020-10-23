package com;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@BeforeClass
	public void before() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akaduppi\\Desktop\\Projects\\CX portal - Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(20);

		driver.manage().window().maximize();

	}

	@Test(priority =1)

	public void f() throws InterruptedException {

		MethodClass mc = new MethodClass(driver);

		try {

			FileInputStream fileStream = new FileInputStream(
					"C:\\Users\\akaduppi\\Desktop\\Projects\\CX portal - Automation\\ParameterExcel.xlsx");
			// Creating a workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 1; i < rowCount; i++) {
				String un = sheet.getRow(i).getCell(0).getStringCellValue();
				String pwd = sheet.getRow(i).getCell(1).getStringCellValue();
				mc.signIn(un, pwd);
			}
		} catch (Exception e) {

		}

	}// method

	@Test(priority =2)
	public void category() throws InterruptedException {

		driver.get("http://automationpractice.com/index.php");				
		Thread.sleep(20);
		driver.manage().window().maximize();	
		String un = "asha.krishnank@infosys.com";
		String pwd = "Onam@123";
		MethodClass mc = new MethodClass(driver);
		mc.signIn(un, pwd);
		mc.category();

	}

}
