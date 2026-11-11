@web
Feature: RateCalculator

  Scenario: 01_ Verify that a user can convert pound to naira
    Given that a user loads an application under test
    When a user inputs 5 into GBP text field
    Then a user sees "5250.00" value in NGN text field
    When a user clicks on Send Now button
    And a user selects "Union Bank" as the Bank option
    And a user inputs "1234567891" as the account number
    And a user clicks on Send Button
    Then the Text "Transaction successful!" message should appear