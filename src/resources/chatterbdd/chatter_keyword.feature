Feature: Keyword-based match support

  Scenario: Setting up the keyword base
    Given I have a chat program
    When I need a keyword match support
    And I define some keywords
    And I set these keywords up
    Then The program should have same keyword match base as set before