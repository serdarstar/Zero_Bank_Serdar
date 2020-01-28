
Feature: Login Page
  @log
  Scenario: Login Page
    Given the user sign in succesfully
    When the user sends login info
    Then the user logs in succesfully