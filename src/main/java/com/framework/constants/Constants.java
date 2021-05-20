package com.framework.constants;

/**
 * @author arunpand
 * The Class Constants to store all the static values
 */
public class Constants {
	public static final String PROJECTPATH=System.getProperty("user.dir");
	public static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe";
	public static final String GECKODRIVERPATH = System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe";
	public static final int EXPLICITWAIT=10;
	public static final String TESTDATASHEETNAME= "TestData";
	public static final String RUNMANAGERPATH= System.getProperty("user.dir")+"\\src\\test\\resources\\RunManager.xlsx";

}
