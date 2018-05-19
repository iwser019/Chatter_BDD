Feature: Saying words exact match support

  Scenario: A saying that intersects with one of exact match
    Given I have a chat program
    When I need an exact match support
    And I define an exact match like "Ты спишь?" with "Нет"
    And I define an exact match like "Сколько будет два плюс два?" with "Четыре"
    And I set these exact matches up
    Then The program should have exact match for some words from phrase like "Ты спишь? Только честно..."