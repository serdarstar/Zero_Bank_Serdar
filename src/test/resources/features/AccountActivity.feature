Feature: Account Activity

  Background:
    Given the user sign in succesfully
    When the user sends login info
    And the user logs in succesfully
    Given the user is on Account Activity page

  Scenario: Page title
    And Account activity page title must be verified


  Scenario:Default dropdown
    Then Default dropdown should be Savings

  Scenario: Dropdown options
    Then Account dropdown menu items must be verified


  Scenario:Transaction table
  //not finished
    Then transaction table columns should be verified



