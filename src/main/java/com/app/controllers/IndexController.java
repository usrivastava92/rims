package com.app.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.core.file.util.FileUtilites;
import com.app.temp.IconStub;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@GetMapping({ "", "/landing-page", "" })
	public String toLandingPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()
				&& !(authentication instanceof AnonymousAuthenticationToken)) {
			return "forward:/index";
		} else {
			return "landing-page";
		}
	}

	@GetMapping({ "/dashboard", "/index.html", "/index", "/home" })
	public String toDashboard() {
		return "index";
	}

	@GetMapping({ "/icons" })
	public String toConsolidatedIcons() {
		return "consolidated-icons";
	}

	@GetMapping(value = { "/get/icons" }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<IconStub> getIcons() {
		List<IconStub> iconStubs = new ArrayList<>();
		try {
			File icons = FileUtilites.getFileFromResources("final-icons.xls");
			Workbook workbook = new HSSFWorkbook(new FileInputStream(icons));

			DataFormatter dataformatter = new DataFormatter();
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				IconStub iconStub = new IconStub();
				iconStub.setSno(dataformatter.formatCellValue(row.getCell(0)).trim());
				iconStub.setIconTag(dataformatter.formatCellValue(row.getCell(1)).trim());
				iconStub.setCssLink(dataformatter.formatCellValue(row.getCell(2)).trim());
				iconStubs.add(iconStub);
			}

			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return iconStubs;
	}

}
