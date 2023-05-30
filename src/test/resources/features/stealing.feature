Feature: Equipment stealing
  The virologists can steal equipments from paralyzed targets

  Scenario Outline: The virologist tries to steal an equipment from another virologist,
  if successful, the equipment gets added to their inventory
    Given the virologist and its target stand on the same field
    And the target has an equipment
    And the target is paralyzed? "<paralyzed>"
    When they try to steal the equipment from the target
    Then the equipment should get added to their inventory? "<success>"
    And be removed from the targets inventory? "<success>"

    Examples:
      | paralyzed | success |
      | Yes       | Yes     |
      | No        | No      |