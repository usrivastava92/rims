package com.app.startup.configuration;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Value;

import com.app.generic.utilities.ExcelUtility;
import com.app.hibernate.service.BaseService;

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
				List<Row> queryRows = excelUtility.getRowList(sheetName, true);
				for (Row queryRow : queryRows) {
					String query = excelUtility.getCellValue(queryRow.getCell(0)).trim();
					if (query != null && !"".equals(query)) {

						System.out.println("SEEDING CONTROLLER : executing ->" + query);
						baseServiceImpl.executeQuery(query);
					}
				}

			}
			System.out.println("SEEDING CONTROLLER : executing ->" + integrityEnableQuery);
			baseServiceImpl.executeQuery(integrityEnableQuery);
		}
	}

}
