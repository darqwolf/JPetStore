@LoginPage
Feature: JPetStore Login Feature

  Background:
    Given User is on JPetStore login page
  @ValidLogin
  Scenario Outline: Login with valid credentials
    When User enters username "<username>" and password "<password>"
    And Clicks on the login button
    Then User should see the homepage

    Examples: 
      | username  | password |
      | Tharun_06 | run@1234 |

  @InvalidLogin
  Scenario Outline: Login with invalid credentials
    When User enters username "<username>" and password "<password>"
    And Clicks on the login button
    Then User should see an error message

    Examples:
      | username | password |
      | tharun   | run@1234 |
 
     
 
     