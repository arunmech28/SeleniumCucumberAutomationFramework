package com.framework.utils;

import java.util.HashMap;
import java.util.Map;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

/**
 * The Class CurrentThreadInstance is to maintain the scenario level data at thread level since each scenario runs in separate thread
 */
public class CurrentThreadInstance {

	/** The driver. */
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	/** The scenario name. */
	public static ThreadLocal<String> scenarioName = new ThreadLocal<String>();
	
	/** The scenario. */
	public static ThreadLocal<Scenario> scenario = new ThreadLocal<Scenario>();

	/**
	 * Gets the scenario.
	 *
	 * @return the scenario
	 */
	public static Scenario getScenario() {
		return scenario.get();
	}

	/**
	 * Sets the scenario.
	 *
	 * @param scenarioIns the new scenario
	 */
	public static void setScenario(Scenario scenarioIns) {
		scenario.set(scenarioIns);
	}

	/** The current scenario data. */
	public static ThreadLocal<HashMap<String, String>> currentScenarioData = new ThreadLocal<HashMap<String, String>>();
	
	/** The current scenario context. */
	public static ThreadLocal<HashMap<String, String>> currentScenarioContext = new ThreadLocal<HashMap<String, String>>();

	/**
	 * Gets the current scenario context.
	 *
	 * @return the current scenario context
	 */
	public static HashMap<String, String> getCurrentScenarioContext() {
		return currentScenarioContext.get();
	}

	/**
	 * Sets the current scenario context.
	 *
	 * @param scenarioContext the scenario context
	 */
	public static void setCurrentScenarioContext(HashMap<String, String> scenarioContext) {
		currentScenarioContext.set(scenarioContext);
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() {

		return driver.get();

	}

	/**
	 * Sets the web driver.
	 *
	 * @param driverparam the new web driver
	 */
	public static void setWebDriver(WebDriver driverparam) {

		driver.set(driverparam);
	}

	/**
	 * Gets the current scenario name.
	 *
	 * @return the current scenario name
	 */
	public static String getCurrentScenarioName() {

		return scenarioName.get();

	}

	/**
	 * Sets the current scenario name.
	 *
	 * @param scenario the new current scenario name
	 */
	public static void setCurrentScenarioName(String scenario) {

		scenarioName.set(scenario);
	}

	/**
	 * Gets the current scenario data.
	 *
	 * @return the current scenario data
	 */
	public static Map<String, String> getCurrentScenarioData() {

		return currentScenarioData.get();

	}

	/**
	 * Sets the current scenario data.
	 *
	 * @param alldata the alldata
	 */
	public static void setCurrentScenarioData(HashMap<String, String> alldata) {

		currentScenarioData.set(alldata);
	}

	/**
	 * Gets the field data.
	 *
	 * @param fieldName the field name
	 * @return the field data
	 */
	public static String getFieldData(String fieldName) {
		return currentScenarioData.get().get(fieldName);
	}
}
