package com.framework.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class CurrentThreadInstance {

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public static ThreadLocal<String> scenarioName = new ThreadLocal<String>();
	public static ThreadLocal<HashMap<String, String>> currentScenarioData = new ThreadLocal<HashMap<String, String>>();
	public static ThreadLocal<HashMap<String, String>> currentScenarioContext = new ThreadLocal<HashMap<String, String>>();

	public static HashMap<String, String> getCurrentScenarioContext() {
		return currentScenarioContext.get();
	}

	public static void setCurrentScenarioContext(HashMap<String, String> scenarioContext) {
		currentScenarioContext.set(scenarioContext);
	}

	public static WebDriver getDriver() {

		return dr.get();

	}

	public static void setWebDriver(WebDriver driver) {

		dr.set(driver);
	}

	public static String getCurrentScenario() {

		return scenarioName.get();

	}

	public static void setCurrentScenario(String scenario) {

		scenarioName.set(scenario);
	}

	public static Map<String, String> getCurrentScenarioData() {

		return currentScenarioData.get();

	}

	public static void setCurrentScenarioData(HashMap<String, String> alldata) {

		currentScenarioData.set(alldata);
	}

	public static String getFieldData(String fieldName) {
		return currentScenarioData.get().get(fieldName);
	}
}
