Feature: Chop with an axe
  The virologists can chop other virologists with an axe

  Scenario: The virologist chops the target with an axe and the target dies
    Given the virologist and the chop target stand on the same field
    And the virologist has an axe in their inventory
    When they chop the target with the axe
    Then the target dies
    And axes durability gets decreased by one
