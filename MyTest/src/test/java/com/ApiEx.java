package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiEx {

	@Test
	public void request1() {

		try {

			FileInputStream fileStream = new FileInputStream(
					"C:\\Users\\akaduppi\\Desktop\\Projects\\CX portal - Automation\\apiNames.xlsx");
			// Creating a workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 0; i <= rowCount; i++) {
				String name = sheet.getRow(i).getCell(0).getStringCellValue();
				Response response = RestAssured.get("https://api.genderize.io/?name=" + name);
				int status = response.getStatusCode();
				System.out.println("Status code is " + status);
				System.out.println(response.asString());

				Assert.assertEquals(200, status);
				System.out.println("Assertion True");
			}
		} catch (Exception e) {
			System.out.println("Getting data from excel failed");
		}

	}

}
