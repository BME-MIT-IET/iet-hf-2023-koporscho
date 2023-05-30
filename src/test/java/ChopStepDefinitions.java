package test.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import koporscho.*;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ChopStepDefinitions {
    private Virologist virologist = new Virologist("caster");
    private Virologist target = new Virologist("target");
    private Equipment axe;
    private int initialDurability;
    Field startingField = new City();
    @Given("the virologist and the chop target stand on the same field")
    public void the_virologist_and_the_chop_target_stand_on_the_same_field() {
        virologist.Move(startingField);
        target.Move(startingField);
    }
    @Given("the virologist has an axe in their inventory")
    public void the_virologist_has_an_axe_in_their_inventory() {
        StatusEffect deadEffect = new StatusEffect();
        deadEffect.SetDead(true);
        axe = new Equipment(deadEffect, 3);
        initialDurability = axe.GetDurability();
        virologist.AddEquipment(axe);
    }
    @When("they chop the target with the axe")
    public void they_chop_the_target_with_the_axe() {
        virologist.Chop(target);
    }
    @Then("the target dies")
    public void the_target_dies() {
        boolean dead = false;
        ArrayList<StatusEffect> targetStatusEffect = target.GetStatusEffects();
        for (StatusEffect se : targetStatusEffect) {
            if (se.GetDead()) {
                dead = true;
            }
        }
        assertThat(dead).isTrue();
    }
    @Then("axes durability gets decreased by one")
    public void axes_durability_gets_decreased_by_one() {
        assertThat(axe.GetDurability()).isEqualTo(initialDurability - 1);
    }
}
