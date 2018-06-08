package models;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void newTeamObjectIsInstantiatedCorrectly_true() throws Exception {
        Team team = new Team("Blue Moon Boys", "Rockers");
        assertTrue(team instanceof Team);
    }

    @Test
    public void getName_correctlyGetsName_blueMoonBoys() throws Exception {
        Team team = new Team("Blue Moon Boys", "Rockers");
        String expected= "Blue Moon Boys";
        assertEquals(expected, team.getName());
    }

    @Test
    public void getDescription_correctlyGetsDescription_rockers() throws Exception {
        Team team = new Team("Blue Moon Boys", "Rockers");
        String expected= "Rockers";
        assertEquals(expected, team.getDescription());
    }

//    @Test
//    public void getId_correctlyGetsId_1() throws Exception {
//        Team team = new Team();
//        Team otherTeam = new Team();
//        assertEquals(1, team.getId());
//        assertEquals(2, otherTeam.getId());
//    }


    @Test
    public void setName_correctlySetsName_blueMoonBoys() throws Exception {
        Team team = new Team("Blue Moon Boys", "Rockers");
        team.setName("The Blue Moon Boys");
        assertEquals("The Blue Moon Boys", team.getName());
    }

    @Test
    public void setDescription_correctlySetsDescription_aTeam() throws Exception {
        Team team = new Team("Blue Moon Boys", "Rockers");
        team.setDescription("A Team");
        assertEquals("A Team", team.getDescription());
    }

}