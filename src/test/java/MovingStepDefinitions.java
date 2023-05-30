package test.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import koporscho.City;
import koporscho.Field;
import koporscho.Shelter;
import koporscho.Virologist;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingStepDefinitions {
    private Virologist virologist= new Virologist("testVirologist");
    private Field startingField = new Shelter();
    private Field fieldToMoveTo = new City();
    private int apBeforeAction;

    @Given("the virologist stands on a field")
    public void the_virologist_stands_on_a_field() {
        virologist.Move(startingField);
    }
    @Given("they have at least one action point")
    public void they_have_at_least_one_action_point() {
        virologist.SetApCurrent(3);
    }
    @When("they try to move to a neighboring field")
    public void they_try_to_move_to_a_neighboring_field() {
        ArrayList<Field> neighbors = new ArrayList<>();
        neighbors.add(startingField);
        fieldToMoveTo.SetNeighbors(neighbors);
        apBeforeAction = virologist.GetApCurrent();
        virologist.Move(fieldToMoveTo);
    }
    @Then("their new position should be set to the field")
    public void their_new_position_should_be_set_to_the_field() {
        assertThat(virologist.GetField()).isNotEqualTo(startingField);
        assertThat(virologist.GetField()).isEqualTo(fieldToMoveTo);
    }
    @Then("their action points should be decreased by one")
    public void their_action_points_should_be_decreased_by_one() {
        assertThat(virologist.GetApCurrent()).isEqualTo(apBeforeAction - 1);
    }
}
