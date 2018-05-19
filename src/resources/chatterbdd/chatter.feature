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