package UtilitiesPackageOfHerPower;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotAndXcelClass {

	public static String captureScreenshotMethod(WebDriver driver , String testName) {

		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotFolder = System.getProperty("user.dir")+"\\BugScreenshot\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot,new File(ScreenshotFolder));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return ScreenshotFolder;
	}
	

	public static Object[][] getTestDataFromExcel(String sheetName) {
		File excelFile = new File(System.getProperty("user.dir")+"\\Automate excel file her power.xlsx");
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fisExcel=new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName); //mvn repository poi,poi oxml.poi oxml schemas

		int rows=sheet.getLastRowNum(); //4 rows
		int cols=sheet.getRow(0).getLastCellNum(); //2 cols

		Object[][] data=new Object[rows][cols];

		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);

			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				switch(cellType) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]= Integer.toString((int)cell.getNumericCellValue());
					break;

				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				case BLANK:
					break;
				case ERROR:
					break;
				case FORMULA:
					break;
				case _NONE:
					break;
				default:
					break;

				}
			}
		}
		return data;
	}

	
}

