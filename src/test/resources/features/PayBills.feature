Feature: Pay Bills

  Background:
    Given the user sign in succesfully
    When the user sends login info
    And the user logs in succesfully
    Given the user is on Account Activity page
    Then the user navigates to pay bill tab


  Scenario: Pay bills navigation
    Then pay bill page title should be verified

  Scenario: Successful payment
    Then after payment, successful message displayed


  Scenario: Alphabetic and numeric input
    Then Amount and date should be correct type
#    //not finished When	user	tries	to	make	a	payment	without	entering	the	amount	or	date,
#  Please	fill	out	this	field	message! should	be	displayed.
#  Amount	field	should	not	accept	alphabetical	or	special	characters.	Date	field	should
#  not	accept	alphabetical	characters kismi yapilacak




