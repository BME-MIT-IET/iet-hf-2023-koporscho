Feature: Bear destroys storage
  The bear steps on the storage and destroys the materials in the storage

  Scenario: The virologist infected with bear steps on a storage field and destroys the materials in it
    Given the virologist is infected with bear
    And a neighboring storage field has materials in it
    When the bear steps on a neighboring storage field
    Then the materials in the storage get destroyed