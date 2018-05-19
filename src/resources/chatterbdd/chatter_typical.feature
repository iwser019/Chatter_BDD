Feature: Typical phrase match support

  Scenario: Setting up the typical match base
    Given I have a chat program
    When I need a typical match support
    And I define some typical phrases
    And I set these typical phrases up
    Then The program should have the same typical matches as set before

  Scenario: A saying with a typical match
    Given I have a chat program
    When I need a typical match support
    And I define some typical phrases
    And I set these typical phrases up
    And I decided to ask something like "Не знаю."
    Then The program should have a typical phrase match for the saying

  Scenario: A saying without a typical match
    Given I have a chat program
    When I need a typical match support
    And I define some typical phrases
    And I set these typical phrases up
    And I decided to ask something like "фывапролджэ"
    Then The program should not have a typical phrase match for the saying