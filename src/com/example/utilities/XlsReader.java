package com.example.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {

	public static List ReadExcelFile() throws IOException {
		List ExcelDataRows = new ArrayList();
		File excelFile = new File("Registration-data.xlsx");
	    FileInputStream fis = new FileInputStream(excelFile);


	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    Iterator<Row> rowIt = sheet.iterator();

	    while(rowIt.hasNext()) {
	    	Data data = new Data();
	      Row row = rowIt.next();
	      Iterator<Cell> cellIterator = row.cellIterator();

	      while (cellIterator.hasNext()) {
	        Cell cell = cellIterator.next();

            if (cell.getColumnIndex() == 0) {
                data.setName(String.valueOf(cell.getStringCellValue()));
            }
            //Cell with index 2 contains marks in Science
            else if (cell.getColumnIndex() == 1) {
                data.setUsername(String.valueOf(cell.getStringCellValue()));
            }
            //Cell with index 3 contains marks in English
            else if (cell.getColumnIndex() == 2) {
                data.setEmail(String.valueOf(cell.getStringCellValue()));
            }
            else if (cell.getColumnIndex() == 3) {
                data.setPassword(String.valueOf(cell.getStringCellValue()));
            }
            else if (cell.getColumnIndex() == 4) {
                data.setLanguage(String.valueOf(cell.getStringCellValue()));
            }
            else if (cell.getColumnIndex() == 5) {
                data.setAddReq(Boolean.valueOf(cell.getBooleanCellValue()));
            }
            
	      }
	      ExcelDataRows.add(data);
	    }

	    workbook.close();
	    fis.close();
	    return ExcelDataRows;
	  }
	
	public static void main(String args[]) throws IOException {
		 
        List studentList = ReadExcelFile();
 
        System.out.println(studentList);
    }
	
}