package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPOI {
	String path;
	int sheetNo;
	
	public ExcelPOI(String path , int sheetNo) {
		this.path = path;
		this.sheetNo = sheetNo;
	}
	public HashMap<String, String> getData() {
	    HashMap<String, String> data = new HashMap<>();
	    try (FileInputStream fis = new FileInputStream(path);
	         Workbook wb = new XSSFWorkbook(fis)) {

	        Sheet sheet = wb.getSheetAt(sheetNo);
	        int rows = sheet.getPhysicalNumberOfRows();

	        for (int i = 0; i < rows; i++) {
	            Row row = sheet.getRow(i);
	            if (row != null) {
	                Cell keyCell = row.getCell(0);
	                Cell valueCell = row.getCell(1);

	                String key = getCellValueAsString(keyCell);
	                String value = getCellValueAsString(valueCell);

	                data.put(key, value);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return data;
	}

	private String getCellValueAsString(Cell cell) {
	    if (cell == null) return "";
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue().trim();
	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return cell.getDateCellValue().toString();
	            } else {
	                return String.valueOf(cell.getNumericCellValue());
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case FORMULA:
	            return cell.getCellFormula();
	        case BLANK:
	            return "";
	        default:
	            return "";
	    }
	}
}
