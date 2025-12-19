Feature: Employee adding Feature 

 Background: Common steps
    Given user is on login page
    
  @tag
  Scenario: Check admin login with valid credentials
    When user enters valid credentials
    Then user should be logged in successfully
   
