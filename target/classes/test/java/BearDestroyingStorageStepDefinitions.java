package test.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import koporscho.*;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BearDestroyingStorageStepDefinitions {
    private Virologist bear = new Virologist("bear");
    private Storage storage = new Storage();

    @Given("the virologist is infected with bear")
    public void the_virologist_is_infected_with_bear() {
        StatusEffect bearEffect = new StatusEffect();
        bearEffect.SetBear(true);
        bearEffect.SetDuration(-1);
        bear.AddEffect(bearEffect);
    }
    @Given("a neighboring storage field has materials in it")
    public void a_neighboring_storage_field_has_materials_in_it() {
        storage.SetTotalSupply(new Materials(10,10));
        storage.SetSupply(new Materials(5,5));
    }
    @When("the bear steps on a neighboring storage field")
    public void the_bear_steps_on_a_neighboring_storage_field() {
        bear.Move(storage);
        bear.Tick();
    }
    @Then("the materials in the storage get destroyed")
    public void the_materials_in_the_storage_get_destroyed() {
        assertThat(storage.GetSupply().GetNucleotide()).isEqualTo(0);
        assertThat(storage.GetSupply().GetAminoAcid()).isEqualTo(0);
    }
}
