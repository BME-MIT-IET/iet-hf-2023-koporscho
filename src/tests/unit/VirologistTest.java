package tests.unit;

import jdk.jshell.spi.ExecutionControl;
import koporscho.*;
import org.junit.jupiter.api.AfterEach;
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
    }

    @Test
    void Move(){
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
    void CraftAgent(){
        
    }

    @Test
    void ApplyAgent(){
        throw new RuntimeException("Not implemented");
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
        throw new RuntimeException("Not implemented");
    }
}