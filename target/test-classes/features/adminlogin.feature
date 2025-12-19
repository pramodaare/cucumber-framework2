Feature: Admin Login Feature
  
  Background: Common steps
    Given user is on login page
    
  @tag
  Scenario: Check admin login with valid credentials
    When user enters valid credentials
    Then user should be logged in successfully
    
  @failure 
  Scenario Outline: Login with invalid credentials
    When user enters username "<username>" and password "<password>"
    Then error message should be displayed as "Invalid credentials or Required "
    
    Examples:
      | username     | password     |
      | uese@@111v   | admin123     | 
      | Admin        | wtwu@1233    |
      | afhjdkld | ajflakl   |
      | Admin    |           |
      |          | admin123  |
      |          |           |
      | djhdksldl;dkflk142638228@#$%^&jkw48 | sjhskjak$%^^&*12662786gjkajdka |
       
     
      
      
    
    