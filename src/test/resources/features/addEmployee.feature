Feature: Add Employee and update personal details in OrangeHRM

  Background:
    Given user is on login page
    When user enters valid credentials
    Then user should be logged in successfully

  Scenario: Add new employee and update personal details
    When user clicks on PIM module
    And user clicks on Add Employee
    And user enters employee details
    And user clicks on Save button
    Then user should be navigated to Employee List page
    When user clicks on Personal Details
    And user add remaining missing details
    Then personal details should be saved successfully
    When user enter remaining details in Custom fields
    Then Custom fields should be saved successfully