package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_equals() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assertFalse(team.equals("test-team"));
    }

    @Test
    public void equals_returns_true_for_teams_with_same_name_and_members() {
        Team other = new Team("test-team");

        assertTrue(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_teams_with_different_names() {
        Team other = new Team("another-team");

        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_teams_with_different_members() {
        Team other = new Team("test-team");
        team.addMember("Alice");

        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_returns_same_value_for_equal_teams() {
        Team other = new Team("test-team");

        assertTrue(team.equals(other));
        assertEquals(team.hashCode(), other.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        // Pin the current implementation to distinguish the equivalent & mutation.
        int expectedResult = -1226298695;

        assertEquals(expectedResult, team.hashCode());
    }


}
