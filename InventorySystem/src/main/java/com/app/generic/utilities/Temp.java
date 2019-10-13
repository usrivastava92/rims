package com.app.generic.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Temp {

	public static void main(String[] args) {
		File file = FileUtilites.getFileFromResources("seedSql/PRODUCT_CLASSIFICATION.sql");


		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String query = br.readLine();
			while (query != null) {
				try {
					System.out.println("SEEDING CONTROLLER : executing ->" + query);
				} catch (Exception e) {
					e.printStackTrace();
				}
				query = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void seedQueryGenerator() {
		ExcelUtility excelUtility = new ExcelUtility(new File("/Users/utkarsh/Downloads/prods.xls"));

		List<Row> rows = excelUtility.getRowList(0, true);

		Set<String> genAttDupCheck = new HashSet<>();
		Set<String> prodClassDupCheck = new HashSet<>();

		for (Row row : rows) {
			String productCategoryTree = excelUtility.getCellValue(row.getCell(1)).trim().replace("'", "''");
			String productSpecs = excelUtility.getCellValue(row.getCell(4)).trim().replace("'", "''");

			prodClassDupCheck.add(productCategoryTree.replace("[\"", "").replace("\"]", ""));

			if (productSpecs != null && !"".equals(productSpecs.trim())) {
				try {
					JSONArray jsonArray = (JSONArray) getJsonObject(productSpecs).get("product_specification");
					int length = jsonArray.length();
					for (int i = 0; i < length; i++) {
						JSONObject object = (JSONObject) jsonArray.get(i);
						try {
							String outString = object.get("key") + " => " + object.get("value");
							genAttDupCheck.add(outString);
						} catch (Exception e) {
							String key = "MISC";
							String outString = key + " => " + object.get("value");
							genAttDupCheck.add(outString);
						}
					}
				} catch (Exception e) {
					try {
						JSONObject jSONObject = (JSONObject) getJsonObject(productSpecs).get("product_specification");
						String outString = jSONObject.get("key") + " => " + jSONObject.get("value");
						genAttDupCheck.add(outString);
					} catch (Exception ee) {
					}
				}
			}

		}

		int prodClassId = 1;

		ArrayList<String> prodClassList = new ArrayList<>();
		prodClassList.addAll(prodClassDupCheck);

		String productClassData = "";
		ArrayList<String> prodClassListCopy = (ArrayList<String>) prodClassList.clone();

		for (String s : prodClassListCopy) {
			String[] catToken = s.split(" >> ");
			if (catToken.length >= 4) {
				String parentCategory1 = catToken[0];
				String parentCategory2 = catToken[1];
				String subCategory1 = catToken[2];
				String subCategory2 = catToken[3];

				String query = MasterSeedCreator.createProductClassisifcationQuery(String.valueOf(prodClassId++),
						parentCategory1, parentCategory2, subCategory1, subCategory2);
				System.out.println(query);
				productClassData += query + "\n";
			} else {
				prodClassList.remove(s);
			}
		}

		writeDataToFile(new File("/Users/utkarsh/Downloads/productClassData" + new Date().toString() + ".sql"),
				productClassData);
		writeDataToFile(new File("/Users/utkarsh/Downloads/prodClassList" + new Date().toString() + ".sql"),
				prodClassList.toString());

		int genericAttId = 1;

		List<String> genAttList = new ArrayList<>();
		genAttList.addAll(genAttDupCheck);

		String genAttData = "";

		for (String genAtt : genAttList) {

			String[] tok = genAtt.split("=>");
			String key = tok[0].trim();
			String value = tok[1].trim();

			String query = MasterSeedCreator.createGenericAttributeQuery(String.valueOf(genericAttId++), key, value,
					value, "", "");
			System.out.println(query);

			genAttData += query + "\n";
		}

		writeDataToFile(new File("/Users/utkarsh/Downloads/genAttList" + new Date().toString() + ".sql"),
				genAttList.toString());
		writeDataToFile(new File("/Users/utkarsh/Downloads/genAttData" + new Date().toString() + ".sql"), genAttData);

		String productAttData = "";
		String productData = "";

		int productId = 1;

		for (Row row : rows) {
			String productName = excelUtility.getCellValue(row.getCell(0)).trim().replace("'", "''");
			String productCategoryTree = excelUtility.getCellValue(row.getCell(1)).trim().replace("'", "''");
			String brand = excelUtility.getCellValue(row.getCell(3)).trim().replace("'", "''");
			String productSpecs = excelUtility.getCellValue(row.getCell(4)).trim().replace("'", "''");
			String pid = excelUtility.getCellValue(row.getCell(5)).trim().replace("'", "''");

			int productCategoryId = prodClassList.indexOf(productCategoryTree.replace("[\"", "").replace("\"]", ""))
					+ 1;

			String query = MasterSeedCreator.createProductQuery(String.valueOf(productId), pid, productName, "", brand,
					String.valueOf(productCategoryId));

			System.out.println(query);
			productData += query + "\n";

			if (productSpecs != null && !"".equals(productSpecs.trim())) {
				try {
					JSONArray jsonArray = (JSONArray) getJsonObject(productSpecs).get("product_specification");
					int length = jsonArray.length();
					for (int i = 0; i < length; i++) {
						JSONObject object = (JSONObject) jsonArray.get(i);
						try {
							String outString = object.get("key") + " => " + object.get("value");
							int attributeId = genAttList.indexOf(outString) + 1;

							String subq = MasterSeedCreator.createProductAttributeQuery(String.valueOf(productId),
									String.valueOf(attributeId));

							productAttData += subq + "\n";

							System.out.println(subq);
						} catch (Exception e) {
							String key = "MISC";
							String outString = key + " => " + object.get("value");
							int attributeId = genAttList.indexOf(outString) + 1;

							String subq = MasterSeedCreator.createProductAttributeQuery(String.valueOf(productId),
									String.valueOf(attributeId));

							System.out.println(subq);
						}
					}
				} catch (Exception e) {
					try {
						JSONObject jSONObject = (JSONObject) getJsonObject(productSpecs).get("product_specification");
						String outString = jSONObject.get("key") + " => " + jSONObject.get("value");
						int attributeId = genAttList.indexOf(outString) + 1;

						String subq = MasterSeedCreator.createProductAttributeQuery(String.valueOf(productId),
								String.valueOf(attributeId));

						productAttData += subq + "\n";
						System.out.println(subq);
					} catch (Exception ee) {
					}
				}
			}

			productId++;

		}

		writeDataToFile(new File("/Users/utkarsh/Downloads/productAttData" + new Date().toString() + ".sql"),
				productAttData);
		writeDataToFile(new File("/Users/utkarsh/Downloads/productData" + new Date().toString() + ".sql"), productData);

		excelUtility.close();
	}

	public static JSONObject getJsonObject(String json) {
		try {
			return new JSONObject(json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
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
