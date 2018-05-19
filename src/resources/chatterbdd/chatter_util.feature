Feature: Utility functions

  Scenario: Splitting phrase into a set of sentences
    Given I have a chat program
    Then The program should be able to split phrases properly

  Scenario: Single sentence processing
    Given I have a chat program
    Then The program should not split a single sentence into a sentences

  Scenario: Null string processing for sentence splitting
    Given I have a chat program
    Then The program should not split a null text