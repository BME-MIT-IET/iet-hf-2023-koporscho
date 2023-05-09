package tests.unit;

import koporscho.*;
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
    void Should_apply_agent_effect_to_target_and_remove_agent_from_inventory(){
        StatusEffect statusEffect = new StatusEffect();
        statusEffect.SetParalyzed(true);
        Agent agentToApply = new Agent(statusEffect,new Materials());
        virologist.AddAgent(agentToApply);
        Virologist target = new Virologist("Target");

        virologist.ApplyAgent(target, agentToApply);

        ArrayList<StatusEffect> targetStatusEffect = target.GetStatusEffects();
        var paralyzed = false;
        for(StatusEffect se: targetStatusEffect){
            if(se.GetParalyzed()){
                paralyzed = true;
            }
        }
        assertThat(paralyzed).isTrue();
        assertThat(agentToApply).isNotIn(virologist.GetAgentInventory());
    }

    @Test
    void Should_not_apply_agent_effect_if_target_is_immune(){
        StatusEffect statusEffect = new StatusEffect();
        statusEffect.SetParalyzed(true);
        Agent agentToApply = new Agent(statusEffect,new Materials());
        virologist.AddAgent(agentToApply);

        Virologist target = new Virologist("Target");
        StatusEffect immuneEffect = new StatusEffect();
        immuneEffect.SetImmunity(1);
        target.AddEffect(immuneEffect);

        virologist.ApplyAgent(target, agentToApply);
        ArrayList<StatusEffect> targetStatusEffect = target.GetStatusEffects();
        var paralyzed = false;
        for(StatusEffect se: targetStatusEffect){
            if(se.GetParalyzed()){
                paralyzed = true;
            }
        }
        assertThat(paralyzed).isFalse();
    }

    @Test
    void Should_add_equipment_to_own_inventory_and_remove_it_from_target_when_stealing(){
        Equipment equipmentToSteal = new Equipment(new StatusEffect(),0);
        Virologist target = new Virologist("TargetVirologist");
        target.AddEquipment(equipmentToSteal);
        StatusEffect paralyzedEffect = new StatusEffect();
        paralyzedEffect.SetParalyzed(true);
        target.AddEffect(paralyzedEffect);
        virologist.StealEquipment(target,equipmentToSteal);

        assertThat(equipmentToSteal).isIn(virologist.GetEquipment());
        assertThat(equipmentToSteal).isNotIn(target.GetEquipment());
    }

    @Test
    void Should_not_be_able_to_steal_if_target_is_not_paralyzed(){
        Equipment equipmentToSteal = new Equipment(new StatusEffect(),0);
        Virologist target = new Virologist("TargetVirologist");
        target.AddEquipment(equipmentToSteal);
        virologist.StealEquipment(target,equipmentToSteal);

        assertThat(equipmentToSteal).isNotIn(virologist.GetEquipment());
        assertThat(equipmentToSteal).isIn(target.GetEquipment());
    }

    @Test
    void Should_apply_equipment_effect_when_adding_equipment_to_inventory(){
        StatusEffect equipmentEffect = new StatusEffect();
        equipmentEffect.SetReflect(true);
        Equipment equipment = new Equipment(equipmentEffect,0);

        virologist.AddEquipment(equipment);

        boolean reflect = false;
        for(StatusEffect ef: virologist.GetStatusEffects()){
            if(ef.GetReflect()){
                reflect = true;
            }
        }
        assertThat(reflect).isTrue();
    }

    @Test
    void Should_remove_equipment_effect_when_removing_equipment_from_inventory(){
        StatusEffect equipmentEffect = new StatusEffect();
        equipmentEffect.SetReflect(true);
        Equipment equipment = new Equipment(equipmentEffect,0);

        virologist.AddEquipment(equipment);
        virologist.RemoveEquipment(equipment);

        boolean reflect = false;
        for(StatusEffect ef: virologist.GetStatusEffects()){
            if(ef.GetReflect()){
                reflect = true;
            }
        }
        assertThat(reflect).isFalse();
    }
    @Test
    void Should_decrease_durability_of_axe_when_chopping(){
        StatusEffect deadEffect = new StatusEffect();
        deadEffect.SetDead(true);
        Equipment axe = new Equipment(deadEffect,2);
        virologist.AddEquipment(axe);
        Virologist target = new Virologist("TargetVirologist");

        virologist.Chop(target);
        assertThat(axe.GetDurability()).isEqualTo(1);
    }
}