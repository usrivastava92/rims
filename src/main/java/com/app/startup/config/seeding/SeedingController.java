package com.app.startup.config.seeding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.app.core.file.util.FileUtilites;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;

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
    public void performSeedingOperation() throws FileNotFoundException, IOException, URISyntaxException {

        if (Boolean.valueOf(seedflag)) {

            DataFormatter dataFormatter = new DataFormatter();

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

            Workbook workbook = new HSSFWorkbook(
                    new FileInputStream(FileUtilites.getFileFromResources("SeedData.xls")));

            Sheet sheetSeq = workbook.getSheet("SHEET_SEQ");

            Iterator<Row> sheetSeqIterator = sheetSeq.iterator();

            if (sheetSeqIterator.hasNext()) {
                sheetSeqIterator.next();
            }

            Sheet integrityToggle = workbook.getSheet("INTEGRITY_TOGGLE");
            Iterator<Row> integrityToggleIterator = integrityToggle.iterator();

            if (integrityToggleIterator.hasNext()) {
                integrityToggleIterator.next();
            }

            String integrityEnableQuery = "";
            String integrityDisableQuery = "";

            while (integrityToggleIterator.hasNext()) {
                Row integrityToggleRow = integrityToggleIterator.next();
                if (dbType.equals(dataFormatter.formatCellValue(integrityToggleRow.getCell(0)))) {
                    integrityEnableQuery = dataFormatter.formatCellValue(integrityToggleRow.getCell(1));
                    integrityDisableQuery = dataFormatter.formatCellValue(integrityToggleRow.getCell(2));
                    break;
                }
            }

            System.out.println("SEEDING CONTROLLER : executing ->" + integrityDisableQuery);
            baseServiceImpl.executeQuery(integrityDisableQuery);

            while (sheetSeqIterator.hasNext()) {
                Row row = sheetSeqIterator.next();
                String sheetName = dataFormatter.formatCellValue(row.getCell(0)).trim();
                String fileType = dataFormatter.formatCellValue(row.getCell(1)).trim().toUpperCase();

                if (fileType.equals("FILE")) {
                    try (BufferedReader br = new BufferedReader(
                            new FileReader(FileUtilites.getFileFromResources("SEED_SQL/" + sheetName + ".sql")))) {
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

                    Sheet sheet = workbook.getSheet(sheetName);

                    Iterator<Row> rowIterator = sheet.iterator();

                    if (rowIterator.hasNext()) {
                        rowIterator.next();
                    }

                    while (rowIterator.hasNext()) {
                        Row queryRow = rowIterator.next();
                        String query = dataFormatter.formatCellValue(queryRow.getCell(0)).trim();
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

            workbook.close();
        }
    }

}
