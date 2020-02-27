
Feature: Purchase foreign currency

  Background:
    Given the user sign in succesfully
    When the user sends login info
    And the user logs in succesfully
    Given the user is on Account Activity page
    Then the user navigates to pay bill tab

@tes
  Scenario: Available	currencies
    Given the user is on the Purchase Foreign Currency tab
    Then the following options should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New  Zealand (dollar) |
      | Singapore (dollar)    |

    Scenario: Error message for not selecting currency
      Given the user is on the Purchase Foreign Currency tab
      When the user tries to calculate cost without selecting a currency
      Then error message should be displayed

  Scenario: Error message for not entering value
    Given the user is on the Purchase Foreign Currency tab
    When the user tries to calculate cost without entering value
    Then error message should be displayed
