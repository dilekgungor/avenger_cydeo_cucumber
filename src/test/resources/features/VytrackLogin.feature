Feature: Vytrack login feature

  As a user I should be able to login

  Scenario: As a user I should be able to login with valid credential
    Given User is on the login page
    When User enters valid username
    And User enters valid password
    And User click login button
    Then User should be able to see "Dashboard" as title