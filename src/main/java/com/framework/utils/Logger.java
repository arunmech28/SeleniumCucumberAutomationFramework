package com.framework.utils;

public class Logger {

	public static void update(String data) {
		CurrentThreadInstance.getScenario().log("*** LogInfo {"+data+"} ***");
	}
}
