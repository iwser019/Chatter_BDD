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

  Scenario: Splitting phrase into a set of words
    Given I have a chat program
    Then The program should be able to give correct set of words

  Scenario: Single word processing
    Given I have a chat program
    Then The program should not try to split single word