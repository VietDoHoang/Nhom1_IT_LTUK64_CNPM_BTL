package function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import struct.Device;

/*
 * Author: Dinh Duc Lam
 */
public class CreateExcel {
	private int rowCount, colNum;
	private Cell cell;
	private Row row;
	private Sheet sheet;
	private HSSFWorkbook workbook;
	private File file;

	private CellStyle createStyleForTitle(HSSFWorkbook workbook) {
		Font font = workbook.createFont();
		font.setBold(true);
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public String getPath() {
		return file.getAbsolutePath();
	}

	public CreateExcel(List<Device> dvList, String []col, String excelName) throws IOException, SQLException {
    	workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(excelName);
        colNum = col.length;
        CellType colDataType[] = new CellType[colNum];
        
        CellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rowCount); //rowCount = 0
        
        //Write TITLE ROW (FIRST ROW) and set data type
        for (int i=0; i<colNum; i++) {
        	cell = row.createCell(i, CellType.STRING);
            cell.setCellValue(col[i]);
            cell.setCellStyle(style);
            
            if (col[i].equalsIgnoreCase("year") || col[i].equalsIgnoreCase("price") || col[i].equalsIgnoreCase("costprice")) 
            	colDataType[i] = CellType.NUMERIC;
            else colDataType[i] = CellType.STRING;
        }
  
        // Write data to Excel
        for (Device dv : dvList) {
        	String []t = dv.getStringArray();
        	rowCount++;
            row = sheet.createRow(rowCount);
            for (int i=0; i<colNum; i++) {
            	cell = row.createCell(i, colDataType[i]);
	        	if (col[i].equalsIgnoreCase("year")) 
	            	cell.setCellValue(Integer.parseInt(t[i]));
	        	else if(col[i].equalsIgnoreCase("price") || col[i].equalsIgnoreCase("costprice"))
	        		cell.setCellValue(Double.parseDouble(t[i]));
	            else cell.setCellValue(t[i]);
            }
        }
        
        for (int i=0; i<colNum; i++) {
        	sheet.autoSizeColumn(i);
        }
        
        file = new File(excelName + ".xls");
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        workbook.close();
    }
	
}