package tests.unit;

import jdk.jshell.spi.ExecutionControl;
import koporscho.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VirologistTest {
    Virologist virologist;
    Field startingField;
    @BeforeEach
    void setUp() {
        virologist = new Virologist("TestVirologist");
        startingField = new City();
        virologist.Move(startingField);

        virologist.SetMaterials(new Materials(0, 0));
        virologist.SetMaxMaterials(new Materials(15,15));
    }

    @Test
    void Should_move_to_neighboring_field_and_reduce_ap(){
        Field fieldToMoveTo = new Shelter();
        ArrayList<Field> neighbors = new ArrayList<>();
        neighbors.add(startingField);
        fieldToMoveTo.SetNeighbors(neighbors);
        int apBeforeAction = virologist.GetApCurrent();

        virologist.Move(fieldToMoveTo);
        assertThat(virologist.GetApCurrent()).isEqualTo(apBeforeAction - 1);
        assertThat(virologist.GetField()).isNotEqualTo(startingField);
        assertThat(virologist.GetField()).isEqualTo(fieldToMoveTo);
    }

    @Test
    void Should_craft_agent_and_decrease_materials_if_has_enough_materials_and_knows_recipe(){
        Agent agentToCraft = new Agent(new StatusEffect(), new Materials(10,10));
        virologist.LearnRecipe(agentToCraft);
        virologist.AddMaterials(new Materials(15,15));

        virologist.CraftAgent(agentToCraft);
        assertThat(virologist.GetCurrentMaterials().GetNucleotide()).isEqualTo(5);
        assertThat(virologist.GetCurrentMaterials().GetAminoAcid()).isEqualTo(5);
        assertThat(agentToCraft).isIn(virologist.GetAgentInventory());
    }

    @Test
    void Should_not_craft_agent_if_does_not_have_enough_materials(){
        Agent agentToCraft = new Agent(new StatusEffect(), new Materials(10,10));
        virologist.LearnRecipe(agentToCraft);
        virologist.AddMaterials(new Materials(11,6));

        virologist.CraftAgent(agentToCraft);

        assertThat(agentToCraft).isNotIn(virologist.GetAgentInventory());
    }

    @Test
    void Should_not_craft_agent_if_does_not_know_recipe(){
        Agent agentToCraft = new Agent(new StatusEffect(), new Materials(10,10));
        virologist.AddMaterials(new Materials(15,15));

        virologist.CraftAgent(agentToCraft);
        assertThat(agentToCraft).isNotIn(virologist.GetAgentInventory());
    }
    @Test
    void Should_apply_agent_to_target_and_remove_it_from_inventory(){
        StatusEffect statusEffect = new StatusEffect();
        statusEffect.SetParalyzed(true);
        Agent agentToApply = new Agent(statusEffect,new Materials());
        virologist.AddAgent(agentToApply);
        Virologist target = new Virologist("Target");

        virologist.ApplyAgent(target, agentToApply);

        assertThat(agentToApply).isNotIn(virologist.GetAgentInventory());
    }

    @Test
    void StealEquipment(){
        throw new RuntimeException("Not implemented");
    }

    @Test
    void AddEquipment(){
        throw new RuntimeException("Not implemented");
    }

    @Test
    void RemoveEquipment(){
        throw new RuntimeException("Not implemented");
    }

    @Test
    void HandleSteal(){
        throw new RuntimeException("Not implemented");
    }

    @AfterEach
    void tearDown() {
    }
}