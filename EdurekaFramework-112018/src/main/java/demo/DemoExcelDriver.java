package demo;

import commonLibs.utils.ExcelDriver;

public class DemoExcelDriver {
	
	public static void main(String[] args) {

		
		try {
			
			ExcelDriver excelDriver = new ExcelDriver();
			String sheetname = "Test Data";
			String filename = System.getProperty("user.dir")+"/outputFiles/testData.xlsx";
			excelDriver.createExcelWorkbook(filename);
			
			excelDriver.openExcelWorkbook(filename);
			excelDriver.createSheet(sheetname);
			excelDriver.setCellData(sheetname, 1, 1, "Saurabh1");
			excelDriver.setCellData(sheetname, 1, 2, "Saurabh2");
			excelDriver.setCellData(sheetname, 1, 3, "Saurabh3");
			excelDriver.setCellData(sheetname, 1, 4, "Saurabh4");
			
			excelDriver.save();
			excelDriver.cloose();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
