package com.framework.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
	public By txtbox_username = By.name("username");

//	@FindBy(name="username")
//	WebElement txtbox_username;
//	
//	@FindBy(name="password")
//	WebElement txtbox_password;
//	
//	@FindBy(xpath="//*[text()='LOGIN']")
//	WebElement btn_login;

	
	
	public void login(String username, String password) {
	
	}
	
	public void navigateToUrl (String url) {
		goToUrl(url);
	}
}
