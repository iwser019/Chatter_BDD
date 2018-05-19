Feature: Keyword-based match support

  Scenario: Setting up the keyword base
    Given I have a chat program
    When I need a keyword match support
    And I define some keywords
    And I set these keywords up
    Then The program should have same keyword match base as set before
    
  Scenario: A saying with a keyword match
    Given I have a chat program
    When I need a keyword match support
    And I define some keywords
    And I set these keywords up
    Then The program should have keyword match for phrase like "Я этого не знаю."

  Scenario: A saying without a keyword match
    Given I have a chat program
    When I need a keyword match support
    And I define some keywords
    And I set these keywords up
    Then The program should not have keyword match for phrase like "А вот я знаю."