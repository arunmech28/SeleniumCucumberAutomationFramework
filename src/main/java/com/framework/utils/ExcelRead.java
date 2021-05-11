package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	List<String> scenarios;

	public ExcelRead() throws Throwable {
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/RunManager.xlsx");
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		scenarios = getScenarioIds(wb);
	}

	public List<String> getScenarioIds(XSSFWorkbook wb) {

		XSSFSheet sh = wb.getSheet("Runner");
		int row = sh.getLastRowNum();
		List<String> scenarioIDs = new ArrayList<String>();
		for (int i = 1; i < row; i++) {
			if (sh.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Y")) {
				scenarioIDs.add(sh.getRow(i).getCell(1).getStringCellValue());
			}
		}

		return scenarioIDs;
	}

	public Map<String, Map<String, String>> getAllScenarioData() {

		Map<String, Map<String, String>> datas = new HashMap<String, Map<String, String>>();
		XSSFSheet sh = wb.getSheet("TestData");
		int row = sh.getLastRowNum();
		int col = sh.getRow(1).getLastCellNum();
		for (int i = 1; i < row; i++) {
			String scenarioName = sh.getRow(i).getCell(0).getStringCellValue();
			int iteration = Integer.parseInt(sh.getRow(i).getCell(1).getStringCellValue());
			if (scenarios.contains(scenarioName)) {
				if (iteration == 1) {
					datas.put(scenarioName, getScenarioData(sh, i, col));
				} else {
					datas.put(scenarioName + "-iteration" + iteration, getScenarioData(sh, i, col));
				}
			}
		}

		return datas;

	}

	public Map<String, String> getScenarioData(XSSFSheet sh, int rownum, int totalcolumns) {

		Map<String, String> currentScenarioData = new HashMap<String, String>();

		for (int col = 2; col < totalcolumns; col++) {
			String colName = sh.getRow(1).getCell(col).getStringCellValue();
			String colData = sh.getRow(rownum).getCell(col).getStringCellValue();
			currentScenarioData.put(colName, colData);
		}

		return currentScenarioData;

	}

	public static HashMap<String, String> getCurrentScenarioData(String scenarioName, String iteration) throws IOException {
		
		HashMap<String, String> currentScenarioData = new HashMap<String, String>();
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/RunManager.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("TestData");
		int row = sh.getLastRowNum();
		int totalcolumns = sh.getRow(0).getLastCellNum();
		for (int i = 1; i <= row; i++) {
			if(sh.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(scenarioName) 
					&& sh.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(iteration)){
				for (int col = 2; col < totalcolumns; col++) {
					String colName = sh.getRow(0).getCell(col).getStringCellValue();
					String colData = sh.getRow(i).getCell(col).getStringCellValue();
					currentScenarioData.put(colName, colData);
				}
			}
		}
		wb.close();
		return currentScenarioData;
		
	}

}
