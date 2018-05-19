Feature: Chatter basic functions
  In order to talk with someone
  I want to create a chat program

  Scenario:
    Given I have a chat program
    When I try to say nothing
    Then The program does not understand me

  Scenario:
    Given I have a chat program
    When I decided to ask something like "Ты спишь?"
    And I say what I want
    Then The program should give an answer like "Нет"

  Scenario:
    Given  I have a chat program
    When I need an exact match support
    And I define an exact match like "Ты спишь?" with "Нет"
    And I define an exact match like "Сколько будет два плюс два?" with "Четыре"
    And I set these exact matches up
    And I need a typical match support
    And I define some typical phrases
    And I set these typical phrases up
    And I decided to ask something like "Привет"
    And I say what I want
    Then The program should give a correct typical answer