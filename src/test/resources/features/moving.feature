Feature: Moving
  The virologists can move from one field to another neighboring field

  Scenario: The virologist moves to a neighboring field while decreasing their action points by one
    Given the virologist stands on a field
    And they have at least one action point
    When they try to move to a neighboring field
    Then their new position should be set to the field
    And their action points should be decreased by one
