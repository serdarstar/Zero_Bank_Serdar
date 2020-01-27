Feature: Find Transactions in   Account    Activity

  Background:
    Given the user sign in succesfully
    When the user sends login info
    And the user logs in succesfully
    Given the user is on Account Activity page

  Scenario:    Search date   range
    Given  the    user   accesses   the    Find   Transactions   tab
    When the   user   enters date   range  from   "2012-09-01"  to "2012-09-06"
    And    clicks search
    Then results   table  should only   show   transactions   dates  between "2012-09-01"   to   "2012-09-06"
    And the    results    should be sorted by most   recent date
    When the   user   enters date   range  from   "2012-09-02"  to "2012-09-06"
    And clicks search
    Then results   table  should only   show  the transactions   dates  between "2012-09-02"   to   "2012-09-06"
    And the    results    table  should only   not    contain    transactions dated "2012-09-01"

  @acc
  Scenario: search
    Given the    user   accesses   the    Find   Transactions   tab
    When the user enters description "ONLINE"
    And clicks search
    Then the results should only have "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then the results should only have "OFFICE"
    And the results table should not show descriptions containing "OFFICE"

  Scenario: Search description case insensitive
    Given the    user   accesses   the    Find   Transactions   tab
    When the user enters description "ONLINE"
    And clicks search
    Then the results should only have "ONLINE"
    When the user enters description "offline"
    Then the    results    table  should only   not    contain    transactions dated "offline"
