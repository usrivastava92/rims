package com.rims.generic.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;


public class FileUtilites {

	private FileUtilites() {
	}

	public static File getFileFromResources(String fileName) {
		ClassLoader classLoader = new FileUtilites().getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}

	}

	public static String getFileDataAsString(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			String line = br.readLine();
			while (line != null) {
				sb.append(line + "\n");
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String getFileDataAsStr(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			String line = br.readLine();
			while (line != null) {
				sb.append(line + "\n");
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void writeDataToFile(File file, String data) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
			bw.write(data);
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
