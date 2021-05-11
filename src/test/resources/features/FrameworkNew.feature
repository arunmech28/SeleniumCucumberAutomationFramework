Feature: ArunTest

	Scenario: TC_01
		Given I am on login page
		And I login using username and password
		Then I validate homepage is loaded
	
	Scenario: TC_02
		Given I am on login page
		And I login using username and password
		Then I validate homepage is not loaded
		
		Scenario: TC_03
		Given I am on login page
		And I login using username and password
		
		Scenario: TC_04
		Given I am on login page
		And I login using username and password
		
		Scenario: TC_05
		Given I am on login page
		And I login using username and password