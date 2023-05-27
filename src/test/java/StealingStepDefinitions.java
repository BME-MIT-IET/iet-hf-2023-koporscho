package test.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import koporscho.*;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class StealingStepDefinitions {
    private Virologist virologist = new Virologist("caster");
    private Virologist target = new Virologist("target");
    private Equipment equipmentToSteal = new Equipment(new StatusEffect(),3);
    Field startingField = new City();
    @Given("the virologist and its target stand on the same field")
    public void the_virologist_and_its_target_stand_on_the_same_field() {
        virologist.Move(startingField);
        target.Move(startingField);
    }
    @Given("the target has an equipment")
    public void the_target_has_an_equipment() {
        target.AddEquipment(equipmentToSteal);
    }
    @Given("the target is paralyzed? {string}")
    public void the_target_is_paralyzed(String isParalyzed) {
        if(Objects.equals(isParalyzed, "Yes")) {
            StatusEffect paralyzedEffect = new StatusEffect();
            paralyzedEffect.SetParalyzed(true);
            target.AddEffect(paralyzedEffect);
        }
    }
    @When("they try to steal the equipment from the target")
    public void they_try_to_steal_the_equipment_from_the_target() {
        virologist.StealEquipment(target, equipmentToSteal);
    }
    @Then("the equipment should get added to their inventory? {string}")
    public void the_equipment_should_get_added_to_their_inventory(String success) {
        if(Objects.equals(success, "Yes")){
            assertThat(equipmentToSteal).isIn(virologist.GetEquipment());
        }else{
            assertThat(equipmentToSteal).isNotIn(virologist.GetEquipment());
        }
    }
    @Then("be removed from the targets inventory? {string}")
    public void be_removed_from_the_targets_inventory(String success) {
        if(Objects.equals(success, "Yes")){
            assertThat(equipmentToSteal).isNotIn(target.GetEquipment());
        }else{
            assertThat(equipmentToSteal).isIn(target.GetEquipment());
        }
    }
}
