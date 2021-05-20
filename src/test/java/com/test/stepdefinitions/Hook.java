package com.test.stepdefinitions;

import java.io.IOException;
import java.util.HashMap;

import com.framework.utils.CurrentThreadInstance;
import com.framework.utils.Driver;
import com.framework.utils.ExcelRead;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

	public static Scenario scenario;

	/**
	 * Sets the up.
	 * 
	 * @author arunpand
	 * @param scenario - passing the scenario data, so that set and get the current scenario data using thread instance
	 * @throws IOException
	 */
	@Before
	public void setUp(Scenario scenario) throws IOException {
		scenario.log("in before method");
		CurrentThreadInstance.setScenario(scenario);
		CurrentThreadInstance.setCurrentScenarioName(scenario.getName());
		if(scenario.getName().contains("iteration")) {
			String[] arr = scenario.getName().split("-");
			String iteration = arr[arr.length - 1];
			String currenScenarioName = scenario.getName().replace("-iteration-"+iteration, "");
			System.out.println(iteration);
			System.out.println(currenScenarioName);
			System.out.println(ExcelRead.getCurrentScenarioData(currenScenarioName, iteration));
			CurrentThreadInstance.setCurrentScenarioData(ExcelRead.getCurrentScenarioData(currenScenarioName, iteration));
		} else {
			System.out.println(ExcelRead.getCurrentScenarioData(scenario.getName(), "1"));
			CurrentThreadInstance.setCurrentScenarioData(ExcelRead.getCurrentScenarioData(scenario.getName(), "1"));
		}
		new Driver();
		CurrentThreadInstance.setCurrentScenarioContext(new HashMap<String, String>());
	}

	/**
	 * Tear down the current instance of scenario
	 *
	 * @param scenario the scenario
	 */
	@After
	public void tearDown(Scenario scenario) {
		System.out.println("after");
		CurrentThreadInstance.getDriver().close();
	}

}
