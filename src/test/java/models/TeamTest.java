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


}