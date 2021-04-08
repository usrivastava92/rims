package com.rims.startup.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Value;

import com.rims.generic.utilities.ExcelUtility;
import com.rims.generic.utilities.FileUtilites;
import com.rims.hibernate.service.BaseService;

@Named("seedingController")
public class SeedingController {

	@Value("${application.seedOperation}")
	private String seedflag = "true";

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@Value("${spring.jpa.database-platform}")
	private String dialect;

	@PostConstruct
	public void performSeedingOperation() {

		if (Boolean.valueOf(seedflag)) {

			System.out.println("SEEDING CONTROLLER : Beginning seeding operation : seed flag -> " + seedflag);

			dialect = dialect.toUpperCase();
			String dbType = "NA";
			if (dialect.contains("ORACLE")) {
				dbType = "ORACLE";
			} else if (dialect.contains("HSQL")) {
				dbType = "HSQL";
			} else if (dialect.contains("H2")) {
				dbType = "H2";
			} else if (dialect.contains("MYSQL")) {
				dbType = "MYSQL";
			} else if (dialect.contains("MARIA")) {
				dbType = "MARIA";
			}

			System.out.println("SEEDING CONTROLLER : Found database as ->" + dbType);

			ExcelUtility excelUtility = new ExcelUtility("SeedData.xls");

			List<Row> rows = excelUtility.getRowList("SHEET_SEQ", true);

			Row integrityToggleRow = excelUtility.getRowWithFirstColumnAs("INTEGRITY_TOGGLE", dbType, true);

			String integrityEnableQuery = excelUtility.getCellValue(integrityToggleRow.getCell(1));
			String integrityDisableQuery = excelUtility.getCellValue(integrityToggleRow.getCell(2));

			System.out.println("SEEDING CONTROLLER : executing ->" + integrityDisableQuery);
			baseServiceImpl.executeQuery(integrityDisableQuery);

			for (Row row : rows) {
				String sheetName = excelUtility.getCellValue(row.getCell(0)).trim();
				String fileType = excelUtility.getCellValue(row.getCell(1)).trim().toUpperCase();

				if (fileType.equals("FILE")) {
					File productAttribute = FileUtilites.getFileFromResources("SEED_SQL/" + sheetName + ".sql");
					try (BufferedReader br = new BufferedReader(new FileReader(productAttribute))) {
						String query = br.readLine();
						while (query != null) {
							try {
								System.out.println("SEEDING CONTROLLER : executing ->" + query);
								baseServiceImpl.executeQuery(query.trim());
							} catch (Exception e) {
								e.printStackTrace();
							}
							query = br.readLine();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (fileType.equals("SHEET")) {
					List<Row> queryRows = excelUtility.getRowList(sheetName, true);
					for (Row queryRow : queryRows) {
						String query = excelUtility.getCellValue(queryRow.getCell(0)).trim();
						if (query != null && !"".equals(query)) {
							try {
								System.out.println("SEEDING CONTROLLER : executing ->" + query);
								baseServiceImpl.executeQuery(query);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

			try {
				System.out.println("SEEDING CONTROLLER : executing ->" + integrityEnableQuery);
				baseServiceImpl.executeQuery(integrityEnableQuery);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
