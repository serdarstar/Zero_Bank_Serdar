
Feature: Account Summary

  Background:
    Given the user sign in succesfully
    When the user sends login info
    And the user logs in succesfully

  Scenario: Account title
    Then Account page title must be verified


  Scenario: Credit accounts
    And Account types must be verified
    And Credit accounts table must be verified

  Scenario: Savings	account	redirect
    When users click Savings link
    Then Account activity page title must be verified
    And Default dropdown should be Savings

  Scenario:	Brokerage	account	redirect
    When user click Brokerage link
    Then Account activity page title must be verified
    And Default dropdown should be Brokerage

  Scenario:	Credit	Card	account	redirect
    When user clicks Credit Card link
    Then Account activity page title must be verified
    And Default dropdown should be Credit Card

  Scenario:	Loan redirect
    When user clicks Loan link
    Then Account activity page title must be verified
    And Default dropdown should be Loan






