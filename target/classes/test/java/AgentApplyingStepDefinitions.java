package test.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import koporscho.*;

import java.util.ArrayList;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AgentApplyingStepDefinitions {
    private Virologist virologist = new Virologist("caster");
    private Virologist target = new Virologist("target");
    private Agent agentToApply;
    Field startingField = new City();
    @Given("the virologist and the target stand on the same field")
    public void the_virologist_and_the_target_stand_on_the_same_field() {
        virologist.Move(startingField);
        target.Move(startingField);
    }
    @Given("the virologist has an agent in their inventory")
    public void the_virologist_has_an_agent_in_their_inventory() {
        StatusEffect agentEffect = new StatusEffect();
        agentEffect.SetParalyzed(true);
        agentToApply = new Agent(agentEffect,new Materials());
        virologist.AddAgent(agentToApply);
    }
    @Given("the target has immunity? {string}")
    public void the_target_has_immunity(String hasImmunity) {
        if(Objects.equals(hasImmunity, "Yes")){
            StatusEffect immunityEffect = new StatusEffect();
            immunityEffect.SetImmunity(1);
            target.AddEffect(immunityEffect);
        }
    }
    @When("they try to apply the agent")
    public void they_try_to_apply_the_agent() {
        virologist.ApplyAgent(target, agentToApply);
    }
    @Then("the agents effect should be applied to the target? {string}")
    public void the_agents_effect_should_be_applied_to_the_target(String success) {
        ArrayList<StatusEffect> targetStatusEffect = target.GetStatusEffects();
        boolean paralyzed = false;
        for (StatusEffect se : targetStatusEffect) {
            if (se.GetParalyzed()) {
                paralyzed = true;
            }
        }
        if(Objects.equals(success, "Yes")) {
            assertThat(paralyzed).isTrue();
        }else{
            assertThat(paralyzed).isFalse();
        }
    }
    @Then("the agent should be removed from their inventory")
    public void the_agent_should_be_removed_from_their_inventory() {
        assertThat(agentToApply).isNotIn(virologist.GetAgentInventory());
    }
}
