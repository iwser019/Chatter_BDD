Feature: Typical phrase match support

  Scenario: Setting up the typical match base
    Given I have a chat program
    When I need a typical match support
    And I define some typical phrases
    And I set these typical phrases up
    Then The program should have the same typical matches as set before