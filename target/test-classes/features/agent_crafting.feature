Feature: Agent crafting
  The virologists are allowed to craft agent out of materials

  Scenario Outline: The virologist can only craft an agent if they have enough materials and know the recipe for it
    Given the virologist has "<originalNucleotide>" nucleotide and "<originalAminoAcid>" amino acid
    And the agent's crafting cost is "<nucleotideCost>" nucleotide and "<aminoAcidCost>" amino acid
    And the virologist knows "<recipe>"
    When they try to craft an agent
    Then their inventory should have "<agent>"

    Examples:
      | originalNucleotide | originalAminoAcid | nucleotideCost | aminoAcidCost | recipe        | agent
      | 8                  |  8                | 4              | 3             | workingRecipe | expectedAgent
      | 2                  |  1                | 4              | 3             | wrongRecipe   | nothing
      | 5                  |  6                | 2              | 5             | workingRecipe | nothing