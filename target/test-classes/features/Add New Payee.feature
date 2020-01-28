
Feature: Add new Payee

  Background:
    Given the user sign in succesfully
    When the user sends login info
    And the user logs in succesfully
    Given the user is on Account Activity page
    And the user navigates to pay bill tab


  Scenario: Add new Payee
    Given user clicks add new payee link
    Then user creates payee by the following data
      | Payee Name    | The Law Offices of Hyde, Price & Sharks |
      | Payee Address | 100	Same st, Anytown, USA, 10001        |
      | Account       | Checking                                |
      | Payee Details | XYZ Account                             |