package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Team.clearAll();
    }

    @Test
    public void newTeamObjectIsInstantiatedCorrectly_true() throws Exception {
        Team team = new Team();
        assertTrue(team instanceof Team);
    }

    @Test
    public void getMembers_correctlyGetsMembers_arrayList() throws Exception {
        Team team = new Team();
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, team.getMembers());
    }

    @Test
    public void getName_correctlyGetsName_null() throws Exception {
        Team team = new Team();
        String expected= null;
        assertEquals(expected, team.getName());
    }

    @Test
    public void getDescription_correctlyGetsDescription_null() throws Exception {
        Team team = new Team();
        String expected= null;
        assertEquals(expected, team.getDescription());
    }

    @Test
    public void getTeams_correctlyGetsTeams_2() throws Exception {
        Team team = new Team();
        Team otherTeam = new Team();
        assertEquals(2, team.getAll().size());
    }

    @Test
    public void getId_correctlyGetsId_1() throws Exception {
        Team team = new Team();
        Team otherTeam = new Team();
        assertEquals(1, team.getId());
        assertEquals(2, otherTeam.getId());
    }

    @Test
    public void addMembers_correctlyAddsMembers_bill() throws Exception {
        Team team = new Team();
        team.addMember("bill");
        assertEquals("bill", team.getMembers().get(0));
    }

    @Test
    public void setName_correctlySetsName_blueMoonBoys() throws Exception {
        Team team = new Team();
        team.setName("Blue Moon Boys");
        assertEquals("Blue Moon Boys", team.getName());
    }


}