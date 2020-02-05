package commonLibs.utils;

import java.util.Properties;

import org.testng.annotations.DataProvider;

import commonLibs.utils.ConfigReader;
import commonLibs.utils.ExcelDriver;

public class TestDataProvider{
	
	private ExcelDriver excelDriver;
	private String configFileName;
	private String inputFileName;
	private String sheetName;
	private Properties configProperties;
	
			public TestDataProvider() throws Exception {
			
			configFileName = System.getProperty("user.dir") + "/config/config.properties";
			configProperties = ConfigReader.getProperties(configFileName);
			
			inputFileName = configProperties.getProperty("inputFilename");
			sheetName = configProperties.getProperty("sheetName");
			
		}
	
	@DataProvider
		public Object[][] getTestData() throws Exception {
		
		Object[][] data;
		
		excelDriver = new ExcelDriver();
		
		excelDriver.openExcelWorkbook(inputFileName);
		
		int numberofRows = excelDriver.getRowCountoFSheet(sheetName);
		int numberofCellInFirstRow = excelDriver.getCellCount(sheetName, 1);
		
		
		data = new Object[numberofRows + 1][numberofCellInFirstRow];
			
		for (int iRow = 1; iRow <=numberofRows + 1; iRow++) {
		
					
		for (int iCell = 1; iCell <=numberofCellInFirstRow; iCell++) {
			
			data[iRow - 1] [iCell - 1] = excelDriver.getCellData(sheetName, iRow, iCell);

										
		}
	}	
		return data;
	
	}
}
