package pankajrawat.common.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	
	public void getDataFromExcel(String sheetName) throws IOException {
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//pankajrawat//api//dataFiles//Login_Creds.xlsx");
			XSSFWorkbook excel = new XSSFWorkbook(file);
			
			XSSFSheet sheet = excel.getSheet("sheetName");
			
			Iterator<Row> rows = sheet.iterator();
			Row firstRow = rows.next();
			
			Iterator<Cell> cell = firstRow.cellIterator();
			
			while(cell.hasNext()) {
				Cell value = cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("Login")) {
					
					
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
