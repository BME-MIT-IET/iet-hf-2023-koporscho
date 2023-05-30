Feature: Agent applying
  The virologists can apply agents to another virologist

  Scenario Outline: The virologist applies an agent in their inventory to another virologist,
            and its effect gets applied to the target
    Given the virologist and the target stand on the same field
    And the virologist has an agent in their inventory
    And the target has immunity? "<immunity>"
    When they try to apply the agent
    Then the agents effect should be applied to the target? "<success>"
    And the agent should be removed from their inventory

    Examples:
      | immunity | success |
      | Yes      | No      |
      | No       | Yes     |
