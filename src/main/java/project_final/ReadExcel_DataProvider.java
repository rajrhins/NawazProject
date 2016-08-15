package project_final;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ReadExcel_DataProvider extends WrapperMethods {

	public Object[][] exceldata(String fileName, int Sheetno) throws IOException {

		XSSFWorkbook wbook = new XSSFWorkbook(new FileInputStream("./data/" + fileName + ".xlsx"));
		XSSFSheet sheet = wbook.getSheetAt(Sheetno);
		int rowcount = sheet.getLastRowNum();

		int ccount = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowcount][ccount];
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row1 = sheet.getRow(i);

			// int cellcount =row1.getLastCellNum();
			for (int j = 0; j < ccount; j++) {
				XSSFCell cell = row1.getCell(j);
				obj[i - 1][j] = cell.getStringCellValue();

			}

		}
		return obj;

	}

	@Parameters("browser")
	@BeforeMethod(description = "Launch the browser")

	public void remotebrowser(String browser) throws Exception {

		remoteLaunchDriver("http://demo1.opentaps.org/opentaps/control/main", browser);
		login_opentaps();

	}

	@AfterMethod(description = "Close browser", alwaysRun = true)
	public void closebrowser() {
		closeBrowser();
	}

}
