package com.POMFramework.vaishTech.uiSoft.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.POMFramework.vaishTech.uiSoft.helper.listener.Retry;
import com.POMFramework.vaishTech.uiSoft.helper.logger.loggerHelper;
import com.POMFramework.vaishTech.uiSoft.helper.resources.ResourceHelper;

public class ExcelHelper {

	private Logger log = loggerHelper.getlogger(Retry.class);
	
	/**
	 * 
	 * @param excelLocation
	 * @param sheetName
	 * @return
	 */
	public Object[][] getExcelData(String excelLocation, String sheetName) {
		
		try {
			
			FileInputStream file = new FileInputStream(new File(excelLocation));
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheet = workBook.getSheet(sheetName);
			
			int totalRows = sheet.getLastRowNum();
			int totalColumns = sheet.getRow(0).getLastCellNum();
			System.out.println(totalRows);
			System.out.println(totalColumns);
			
			Object[][] data = new Object[totalRows+1][totalColumns];
			
			Iterator<Row> rowIterator = sheet.rowIterator();

			while(rowIterator.hasNext()) {
				int i = 0;
				i++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
					
				while (cellIterator.hasNext()) {

					int j = 0;
					j++;
						Cell cell = cellIterator.next();
						switch (cell.getCellTypeEnum()) {
						
						case STRING:
							data[i-1][j-1] = cell.getStringCellValue();
							break;
						
						case NUMERIC:
							data[i-1][j-1] = cell.getNumericCellValue();
							break;
						
						case BOOLEAN:
							data[i-1][j-1] = cell.getBooleanCellValue();
							break;
						
						case FORMULA:
							data[i-1][j-1] = cell.getCellFormula();
							break;
						
						default:
							System.out.println("No Matching ENUM found.");
							break;
						} 
					}
			}
			
			return data;
			
		} catch (Exception e) {
			
				e.printStackTrace();
				return null;
		}
		
	}
	
	/**
	 * 
	 * @param excelLocation
	 * @param sheetName
	 * @param testCaseName
	 * @param testStatus
	 */
	public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus) {
		
		try {
			
			FileInputStream file = new FileInputStream(new File(excelLocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowNum = sheet.getLastRowNum();
			
			for(int i =1; i<=rowNum; i++) {
				
				XSSFRow r = sheet.getRow(i);
				String cellValue = r.getCell(0).getStringCellValue();
				
				if(cellValue.contains(testCaseName)) {
					
					r.createCell(1).setCellValue(testStatus);
					file.close();
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					log.info("Status updated..");
					break;
				}
				
				
			}
			
			
	
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}	

	
	public static void main(String[] args) {
		
		ExcelHelper ExcelHelper = new ExcelHelper();
//		Object[][] data = ExcelHelper.getExcelData(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\TESTData.xlsx"), "SHEET");
		ExcelHelper.updateResult(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\TESTData.xlsx"), "Login", "Login", "PASS");
		ExcelHelper.updateResult(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\TESTData.xlsx"), "Login", "CTM", "FAIL");
		ExcelHelper.updateResult(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\TESTData.xlsx"), "Login", "Contact", "PASS");
	
	}

	}
	

