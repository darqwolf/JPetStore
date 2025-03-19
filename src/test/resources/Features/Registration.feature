@RegistrationPage
Feature: JPetStore User Registration

  Scenario Outline: Register a new user and save personal information
    Given User navigates to JPetStore registration page
    When User fills user information with "<username>", "<password>", "<repeatPassword>"
    And User fills account information with "<firstName>", "<lastName>", "<email>", "<phone>", "<address1>", "<address2>", "<city>", "<state>", "<zip>", "<country>"
    And User selects profile information "<language>", "<category>"
    And Clicks save account information button
    Then User account is successfully created

    Examples: 
      | username  | password | repeatPassword | firstName | lastName | email               | phone      | address1   | address2  | city    | state | zip    | country | language | category |
      | Tharun_06 | run@1234 | run@1234       | Tharun    | M        | emtharun06@mail.com | 9363668158 | 19 east St | MKB Nagar | chennai | TN    | 600039 | India   | english  | FISH     |
