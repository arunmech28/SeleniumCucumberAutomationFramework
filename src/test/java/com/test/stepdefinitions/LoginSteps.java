package com.test.stepdefinitions;

import com.framework.pages.LoginPage;
import com.framework.utils.CurrentThreadInstance;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps {


	
	@Given("^I am on login page$")
    public void navigateToLoginPage() throws Throwable {
		System.out.println("in login page");
		System.out.println("Sceario name is "+CurrentThreadInstance.getCurrentScenario());
		LoginPage loginPage = new LoginPage();
		loginPage.navigateToUrl(TestUtil.getData("url"));
		TestUtil.setScenarioContext("testKey", "Arun Test Data for Scenario Context "+CurrentThreadInstance.getCurrentScenario());
	}
	
	@And("^I login using username and password$")
    public void enterUsername_Password() throws Throwable {
		LoginPage loginPage = new LoginPage();
		System.out.println(TestUtil.getScenarioContext("testKey"));
//		loginPage.login(Hook.getData("username"), Hook.getData("password"));
	}
	
	@Then("I validate homepage is loaded")
	public void i_validate_homepage_is_loaded() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}

}
