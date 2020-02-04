package commonLibs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {

	//To read from  file
	private InputStream fileReader;
	
	//To write into a file
	private OutputStream fileWriter;
		
	//Creating a workbook
	private Workbook excelWorkbook;
	
	//Default name for a file
	private String sExcelFileName;
	
	//sFileName - Complete path including filename
	public void createExcelWorkbook(String sFilename ) throws Exception {
		
		//Removing white spaces from the end
		sFilename = sFilename.trim();
		
		//Putting a empty check
		if (sFilename.isEmpty()) {
			throw new Exception("Invalid file name..");
		}
		
		File file = new File(sFilename);
		
		if (file.exists()) {
			throw new Exception("File already exists..");
		}
		
		if (sFilename.endsWith("xlsx")) {
			excelWorkbook = new XSSFWorkbook();
			
		} else if (sFilename.endsWith("xls")) {
			excelWorkbook = new HSSFWorkbook();
		} else {
			throw new Exception("Invalid file Extension..");
		}
	
		//Creating a output stream with mentioned filename to be written in workbook
		fileWriter = new FileOutputStream(sFilename);
		
		//Writing to a workbook
		excelWorkbook.write(fileWriter);
		
		//Closing output Stream
		excelWorkbook.close();
		
		//Closing created file
		excelWorkbook.close();
		
	}	
	//--------------------------------------------------------------------------------------------------------------------------------

		public void openExcelWorkbook(String sFilename) throws Exception {
			sFilename = sFilename.trim();
			if (sFilename.isEmpty()) {
				throw new Exception("File Name not specified..");

		}
			if (!(new File(sFilename)).exists()) {
				throw new Exception("File doesnot exists..");
		}
			
			//Reading data from an excel sheet
			fileReader = new FileInputStream(sFilename);
			
			//Assigning sheet name to a global variable
			sExcelFileName = sFilename;
			
			//Representing or converting raw data read from stream into excel workbook format
			excelWorkbook = WorkbookFactory.create(fileReader);
			
}
//--------------------------------------------------------------------------------------------------------------------------------
		public void save() throws Exception {
			fileWriter = new FileOutputStream(sExcelFileName);
			excelWorkbook.write(fileWriter);
			
			fileWriter.close();
		}

//--------------------------------------------------------------------------------------------------------------------------------		
		
		public void saveAs(String sFileNewName) throws Exception {
			sFileNewName = sFileNewName.trim();
			if (sFileNewName.isEmpty()) {
				throw new Exception("File name does not exists..");
			}
			
			if ((new File(sFileNewName)).exists()) {
				throw new Exception("File already exists..");
			}
		
			fileWriter = new FileOutputStream(sFileNewName)	;
			excelWorkbook.write(fileWriter);
		
			fileWriter.close();	
		}
//--------------------------------------------------------------------------------------------------------------------------------		
		public void cloose() throws Exception {
			excelWorkbook.close();
			
			fileReader.close();	
		}
//--------------------------------------------------------------------------------------------------------------------------------	
		public void createSheet(String sSheetName) throws Exception {
			sSheetName = sSheetName.trim();
			
			if (sSheetName.isEmpty()) {
				throw new Exception("Sheet name not specified..");
			}
			
			Sheet oSheet;
			
			oSheet = excelWorkbook.getSheet(sSheetName);
				if (oSheet !=null) {
					throw new Exception("Sheet Already exists...");
				}
			excelWorkbook.createSheet(sSheetName);
			
		}
//--------------------------------------------------------------------------------------------------------------------------------	
		public int getRowCountoFSheet(String sSheetName) throws Exception {
			sSheetName = sSheetName.trim();
			
			if (sSheetName.isEmpty()) {
				throw new Exception("Sheet name not specified..");
			}
			
			Sheet oSheet;
			oSheet = excelWorkbook.getSheet(sSheetName);
			
			if (oSheet == null) {
				throw new Exception("Sheet doesnot exists...");
			}
			return oSheet.getLastRowNum();
		}
//--------------------------------------------------------------------------------------------------------------------------------	
		public int getCellCount(String sSheetName, int iRow) throws Exception {
			sSheetName = sSheetName.trim();
			
			if(sSheetName.isEmpty()) {
				throw new Exception("Sheet name not specified...");
			}
			Sheet oSheet;
			oSheet = excelWorkbook.getSheet(sSheetName);
			
			if (oSheet == null) {
				throw new Exception("Sheet doesnot exists...");	
		} 
		
			if (iRow < 1) {
				throw new Exception("Row Index start from 1");
			}
			
			Row oRow;
			
			oRow = oSheet.getRow(iRow - 1);
			if (oRow == null) {
				return 0;
			} else {
				return oRow.getLastCellNum();
			}
		}
//--------------------------------------------------------------------------------------------------------------------------------	
			public String getCellData(String sSheetName, int iRow, int iCell) {
				try {
					
					sSheetName = sSheetName.trim();
					
					if(sSheetName.isEmpty()) {
						throw new Exception("Sheet name not specified...");
					}
					Sheet oSheet;
					oSheet = excelWorkbook.getSheet(sSheetName);
					
					if (oSheet == null) {
						throw new Exception("Sheet doesnot exists...");	
				}
					
					if (iRow <1 || iCell <1) {
						throw new Exception("Row and Cell Index Start from 1");
					}
					
					Row oRow;
					
					oRow = oSheet.getRow(iRow - 1);
					if (oRow == null) {
						return " ";
					} 
					
					Cell oCell;
					oCell = oRow.getCell(iCell - 1);
					
					if (oCell == null) {
						return " ";
					}  else {
						if (oCell.getCellTypeEnum() == CellType.NUMERIC) {
							return String.valueOf(oCell.getNumericCellValue());
						} else {
							return oCell.getStringCellValue();
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					return " ";
			}	
		}
//--------------------------------------------------------------------------------------------------------------------------------	
				public void setCellData(String sSheetName, int iRow, int iCell, String sValue) {
					try {
						sSheetName = sSheetName.trim();
					
						if(sSheetName.isEmpty()) {
							throw new Exception("Sheet name not specified...");
						}
						
						Sheet oSheet;
						oSheet = excelWorkbook.getSheet(sSheetName);
						
						if (oSheet == null) {
							throw new Exception("Sheet doesnot exists...");	
					}
						
						if (iRow <1 || iCell <1) {
							throw new Exception("Row and Cell Index Start from 1");
						}
						
						Row oRow;
						
						oRow = oSheet.getRow(iRow - 1);
						if (oRow == null) {
							oSheet.createRow(iRow - 1);
							oRow = oSheet.getRow(iRow - 1);
						}
						
						Cell oCell;
						oCell = oRow.getCell(iCell - 1);
						
						if (oCell == null) {
							oRow.createCell(iCell - 1);
							oCell = oRow.getCell(iCell - 1);
						}
						oCell.setCellValue(sValue);
					}
					
					catch (Exception e) {
						e.printStackTrace();
						
					}
			}
//--------------------------------------------------------------------------------------------------------------------------------	
}