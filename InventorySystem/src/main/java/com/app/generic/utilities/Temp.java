package com.app.generic.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

public class Temp {

	public static void main(String[] args) {
		ExcelUtility excelUtility = new ExcelUtility("D:/Utkarsh/MICS/taxonomy-with-ids.en-US.xls");

		List<Row> rows = excelUtility.getRowList(0, true);

		int id = 1;

		List<String> dupCheck = new ArrayList<>();

		String data = "";

		for (Row row : rows) {
			String parentCategory1 = excelUtility.getCellValue(row.getCell(1)).trim().replace("'", "''");
			String parentCategory2 = excelUtility.getCellValue(row.getCell(2)).trim().replace("'", "''");
			String subCategory1 = excelUtility.getCellValue(row.getCell(3)).trim().replace("'", "''");
			String subCategory2 = excelUtility.getCellValue(row.getCell(4)).trim().replace("'", "''");

			String dupCheckString = parentCategory1 + " " + parentCategory2 + " " + subCategory1 + " " + subCategory2;
			if (!subCategory2.equals("") && !dupCheck.contains(dupCheckString)) {
				String query = MasterSeedCreator.createProductClassisifcationQuery(String.valueOf(id++),
						parentCategory1, parentCategory2, subCategory1, subCategory2);
				System.out.println(query);
				data += query + "\n";
				dupCheck.add(dupCheckString);
			}
		}

		writeDataToFile(new File("D:/Utkarsh/MICS/master.sql"), data);

		excelUtility.close();

	}

	public static void writeDataToFile(File file, String data) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(data);
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
