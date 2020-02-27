
Feature: Find Transactions in   Account    Activity

  Background:
    Given the user sign in succesfully
    When the user sends login info
    And the user logs in succesfully
    Given the user is on Account Activity page
    Given the    user   accesses   the    Find   Transactions   tab
  @log1
  Scenario:    Search date   range
    When the   user   enters date   range  from   "2012-09-01"  to "2012-09-06"
    And    clicks search
    Then results   table  should only   show   transactions   dates  between "2012-09-01"   to   "2012-09-06"
    And the    results    should be sorted by most   recent date
    When the   user   enters date   range  from   "2012-09-02"  to "2012-09-06"
    And clicks search
    Then results   table  should only   show  the transactions   dates  between "2012-09-02"   to   "2012-09-06"
    And the    results    table  should only   not    contain    transactions dated "2012-09-01"


  Scenario: search
    When the user enters description "ONLINE"
    And clicks search
    Then the results should only have "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then the results should only have "OFFICE"
    And the results table should not show descriptions containing "OFFICE"

  Scenario: Search description case insensitive
    When the user enters description "ONLINE"
    And clicks search
    Then the results should only have "ONLINE"
    When the user enters description "online"
    And clicks search
    Then the results table should not show descriptions containing "online"
#    en son kisim fail oluyor cunku description box case insensitive degil, ONLINE yerine online yazinca sonuc bulmuyor, bug var

  Scenario: Type
    When clicks search
    Then the results should show at least one result under Deposit
    And the results should show at least one result under Withdrawal
    When the user selects type "Deposit"
    Then the results should show at least one result under Deposit
    And the results show no result under Withdrawal
    When the user selects type "Withdrawal"
    Then the results should show at least one result under Withdrawal
    And the results should show no result under Deposit




