package tests.stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import koporscho.Agent;
import koporscho.Virologist;

public class AgentCraftingStepDefinitions {
    @Given("the virologist has {int} nucleotide and {int} amino acid")
    public void theVirologistHasNucleotideAndAminoAcid(int nucleotide, int aminoAcid) {
        Virologist virologist = new Virologist("testVirologist");
    }

    @And("the agent's crafting cost is {int} nucleotide and {int} amino acid")
    public void theAgentSCraftingCostIsNucleotideAndAminoAcid(int nucleotide, int aminoAcid) {
    }

    @And("the virologist knows {Agent}")
    public void theVirologistKnows(Agent recipe) {
    }

    @When("they try to craft an agent")
    public void theyTryToCraftAnAgent() {
    }

    @Then("their inventory should have {Agent}")
    public void theirInventoryShouldHave(Agent agent) {
    }
}
