Feature: Generic phrases support

  Scenario: Setting up generic phrases
    Given I have a chat program
    When I define some generic phrases
    And  I set these generic phrases up
    Then The program should have same generic phrases base as set before