Feature: Saying exact match support

  Scenario:
    Given: A have a chat program
    When I need an exact match support
    And I define an exact match like
    | Ты спишь? | Нет |
    And I define an exact match like
    | Сколько будет два плюс два? | Четыре |
    And I set these exact matches up
    Then The program should have the same exact matches as set before