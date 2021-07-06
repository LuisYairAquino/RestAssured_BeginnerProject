package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	/*
	 * Step 1: Add Maven Dependency for excel reading and writing
	 * Step 2. Crate a folder and add excel file and create data in the file
	 * Step 3: Is on the code
	 * Step 4: Is on the code
	 * Step 5: Create a constructor to get excelPath and Sheet Name
	 * Step 6: Create a new class and call the excel functions
	 * */
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}


	//Step 3: Class to create a functions to get row count
	public static void getRowCount() {

			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: " + rowCount);

	}

	//Step 4: Create a function to get data from excel

	public static void getCellData(int rowNum, int colNum) {
			//to avoid the decimal 1.0 type next instead of double valueNum = sheet.getRow(1).getCell(2).getNumericCellValue();
			DataFormatter formatter = new DataFormatter();
			Object valueFormat = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			
			
			//String value = sheet.getRow(1).getCell(0).getStringCellValue();
			//if you want to get an int from your data type this:
			//double valueNum = sheet.getRow(1).getCell(2).getNumericCellValue();
			//System.out.println(value);
			System.out.println(valueFormat);

	}
}