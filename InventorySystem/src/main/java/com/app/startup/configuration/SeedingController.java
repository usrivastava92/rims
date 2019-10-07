package com.app.startup.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Value;

import com.app.generic.utilities.ExcelUtility;
import com.app.hibernate.entity.UserAdditionalInfoPo;
import com.app.hibernate.entity.masters.AuthorityPo;
import com.app.hibernate.entity.masters.RolePo;
import com.app.hibernate.entity.masters.UserPo;
import com.app.hibernate.service.BaseService;

@Named("seedingController")
public class SeedingController {

	@Value("${application.seedOperation}")
	private String seedflag;

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@PostConstruct
	private void performSeedingOperation() {

		if (Boolean.valueOf(seedflag)) {

			System.out.println("Beginning seeding operation : seed flag ->" + seedflag);

			ExcelUtility excelUtility = new ExcelUtility("SeedData.xls");
			Collection<AuthorityPo> authorities = new ArrayList<>();
			List<Row> rowList = excelUtility.getRowList("AUTHORITIES");
			int i = 0;
			for (Row row : rowList) {
				if (i != 0) {
					AuthorityPo authority = new AuthorityPo();
					authority.setName(excelUtility.getCellValue(row.getCell(0)));
					authorities.add(authority);
					baseServiceImpl.persistEntity(authority);
				}
				i++;
			}

			Collection<RolePo> roles = new ArrayList<>();
			rowList = excelUtility.getRowList("ROLE");
			i = 0;
			for (Row row : rowList) {
				if (i != 0) {
					RolePo role = new RolePo();
					role.setName(excelUtility.getCellValue(row.getCell(0)));
					role.setAuthorities(authorities);
					roles.add(role);
					baseServiceImpl.persistEntity(role);
				}
				i++;
			}

			rowList = excelUtility.getRowList("USERS");
			i = 0;
			for (Row row : rowList) {
				if (i != 0) {

					UserPo user = new UserPo();
					user.setUsername(excelUtility.getCellValue(row.getCell(0)));
					user.setPassword(excelUtility.getCellValue(row.getCell(1)));
					user.setUserEnabled((Boolean.valueOf(excelUtility.getCellValue(row.getCell(2)))));
					user.setRoles(roles);
					UserAdditionalInfoPo userAdditionalInfoPo = new UserAdditionalInfoPo();
					userAdditionalInfoPo.setFirstname(excelUtility.getCellValue(row.getCell(3)));
					userAdditionalInfoPo.setLastname(excelUtility.getCellValue(row.getCell(4)));
					userAdditionalInfoPo.setProfileImageLink(excelUtility.getCellValue(row.getCell(5)));
					user.setUserAdditionalInfoPo(userAdditionalInfoPo);

					baseServiceImpl.persistEntity(user);
				}
				i++;
			}
		}
	}

}
