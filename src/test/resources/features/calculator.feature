Feature:Calculator feature

  As a user I should be able to use calculator

  Scenario: Add two numbers
    Given Calculator  app is opened
    When user add 2 with 3
    Then user should see 5 as expected
