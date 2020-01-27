Feature: Purchase foreign currency

  Background:
    Given the user sign in succesfully
    When the user sends login info
    And the user logs in succesfully
    Given the user is on Account Activity page
    Then the user navigates to pay bill tab


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
      | New  Zealand (dollar)  |
      | Singapore (dollar)    |