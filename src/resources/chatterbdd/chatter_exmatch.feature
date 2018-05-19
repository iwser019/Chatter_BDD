Feature: Saying exact match support

  Scenario: Setting up the exact match base
    Given I have a chat program
    When I need an exact match support
    And I define an exact match like "Ты спишь?" with "Нет"
    And I define an exact match like "Сколько будет два плюс два?" with "Четыре"
    And I set these exact matches up
    Then The program should have the same exact matches as set before

  Scenario: A saying with an exact match
    Given I have a chat program
    When I need an exact match support
    And I define an exact match like "Ты спишь?" with "Нет"
    And I define an exact match like "Сколько будет два плюс два?" with "Четыре"
    And I set these exact matches up
    Then The program should have the exact match for saying like "Ты спишь?"

  Scenario: A saying without an exact match
    Given I have a chat program
    When I need an exact match support
    And I define an exact match like "Ты спишь?" with "Нет"
    And I define an exact match like "Сколько будет два плюс два?" with "Четыре"
    And I set these exact matches up
    Then The program should not have the exact match for saying like "фывапролджэ"

  Scenario: Getting an exact match for a saying
    Given I have a chat program
    When I need an exact match support
    And I define an exact match like "Ты спишь?" with "Нет"
    And I define an exact match like "Сколько будет два плюс два?" with "Четыре"
    And I set these exact matches up
    Then The exact match for "Ты спишь?" should be "Нет"