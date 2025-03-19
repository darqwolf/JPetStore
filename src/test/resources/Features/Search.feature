@SearchPage
Feature: JPetStore Search Functionality

  Background: 
    Given User is logged into JPetStore with username "Tharun_06" and password "run@1234"

  @ValidPets
  Scenario Outline: Search for pets and view product details
    When User searches for a pet "<petName>"
    And Clicks on the search button
    And Clicks on the "<productID>" to view details
    Then Product details should be displayed

    Examples: 
      | petName | productID |
      | Fish    | FI-FW-02  |
      | Dog     | K9-BD-01  |
  
  @InvalidPets
  Scenario: Search for a pet that is not available
    When User searches for a pet "Dragon"
    And Clicks on the search button
    Then A empty list should be displayed
