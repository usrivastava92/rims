package com.app.generic.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtility {

	private File xlsFile;
	private DataFormatter dataFormatter = new DataFormatter();
	private HSSFWorkbook workbook;

	public ExcelUtility(String fileName) {
		try {
			this.xlsFile = FileUtilites.getFileFromResources(fileName);
			this.workbook = new HSSFWorkbook(new FileInputStream(xlsFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Sheet getSheet(int sheetIndex) {
		return this.workbook.getSheetAt(sheetIndex);
	}

	public Sheet getSheet(String sheetName) {
		return this.workbook.getSheet(sheetName);
	}

	public Row getRow(String sheetName, int rowIndex) {
		return getSheet(sheetName).getRow(rowIndex);
	}

	public List<Row> getRowList(String sheetName) {
		Sheet sheet = getSheet(sheetName);
		List<Row> rowList = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			rowList.add(rowIterator.next());
		}
		return rowList;
	}

	public Row getRow(int sheetIndex, int rowIndex) {
		return getSheet(sheetIndex).getRow(rowIndex);
	}

	public List<Row> getRowList(int sheetIndex) {
		Sheet sheet = getSheet(sheetIndex);
		List<Row> rowList = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			rowList.add(rowIterator.next());
		}
		return rowList;
	}

	public String getCellValue(Cell cell) {
		return this.dataFormatter.formatCellValue(cell);
	}

	public HSSFWorkbook getWorkbook() {
		return this.workbook;
	}

	public void closeAllResources() {
		try {
			this.workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeWorkbookToFile(Workbook workbook, File file) throws FileNotFoundException, IOException {
		try (FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath())) {
			workbook.write(outputStream);
		}
	}

}
