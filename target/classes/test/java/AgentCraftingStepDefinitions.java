package test.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import koporscho.Agent;
import koporscho.Materials;
import koporscho.StatusEffect;
import koporscho.Virologist;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AgentCraftingStepDefinitions {
    private Virologist virologist= new Virologist("testVirologist");
    private Agent agentToCraft;
    @Given("the virologist has {int} nucleotide and {int} amino acid")
    public void the_virologist_has_nucleotide_and_amino_acid(Integer nucleotide, Integer aminoAcid) {
        virologist.SetMaterials(new Materials(nucleotide, aminoAcid));
    }
    @Given("the agent crafting cost is {int} nucleotide and {int} amino acid")
    public void the_agent_crafting_cost_is_nucleotide_and_amino_acid(Integer nucleotide, Integer aminoAcid) {
        agentToCraft = new Agent(new StatusEffect(), new Materials(nucleotide, aminoAcid));
    }
    @Given("the virologist knows the recipe")
    public void the_virologist_knows_the_recipe() {
        virologist.LearnRecipe(agentToCraft);
    }
    @When("they try to craft an agent")
    public void they_try_to_craft_an_agent() {
        virologist.CraftAgent(agentToCraft);
    }
    @Then("their inventory should have the agent? {string}")
    public void their_inventory_should_have_the_agent(String truthValue) {
        if(Objects.equals(truthValue, "Yes")) {
            assertThat(agentToCraft).isIn(virologist.GetAgentInventory());
        }else{
            assertThat(agentToCraft).isNotIn(virologist.GetAgentInventory());
        }
    }
}
