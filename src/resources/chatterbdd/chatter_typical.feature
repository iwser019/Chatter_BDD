Feature: Typical phrase match support

  Scenario: Setting up the typical match base
    Given I have a chat program
    When I need a typical match support
    And I define a typical phrases like |"Я тоже не знаю.", "А почему?", "Жаль."| for "Не знаю."
    Then The program should have the same typical matches as set before