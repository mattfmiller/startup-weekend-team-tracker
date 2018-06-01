package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
}