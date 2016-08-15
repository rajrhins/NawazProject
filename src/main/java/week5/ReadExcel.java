package week5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public void excel_read() throws IOException {
		FileInputStream fis = new FileInputStream(new File("./data/Login1.xlsx"));

		XSSFWorkbook wbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);

		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row1 = sheet.getRow(i);
			int cell =row1.getLastCellNum();
			for (int j = 0; j < cell; j++) {
				XSSFCell cell1 = row1.getCell(j);
				System.out.println(cell1.getStringCellValue());
			}
			
			
		}
		
	}

}
