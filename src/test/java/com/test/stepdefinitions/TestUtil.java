package com.test.stepdefinitions;

import java.util.HashMap;

import com.framework.utils.CurrentThreadInstance;

public class TestUtil {

	
	public static String getData(String fieldName) {
		return CurrentThreadInstance.getCurrentScenarioData().get(fieldName);
	}
	
	public static String getScenarioContext(String field) {
		return CurrentThreadInstance.getCurrentScenarioContext().get(field);
	}
	
	public static void setScenarioContext(String field, String value) {
		HashMap<String,String> scenarioContext = new HashMap<String, String>();
		scenarioContext = CurrentThreadInstance.getCurrentScenarioContext();
		scenarioContext.put(field, value);
		CurrentThreadInstance.setCurrentScenarioContext(scenarioContext);
	}
}
