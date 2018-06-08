package dao;

import models.Team;
import org.junit.*;
import org.sql2o.*;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oTeamDaoTest {
    private Sql2oTeamDao teamDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        teamDao = new Sql2oTeamDao(sql2o);
        conn = sql2o.open();
    }

    public Team setupNewTeam(){
        return new Team("Blue Moon Boys", "Rockers");
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingTeamSetsId() {
        Team testTeam = setupNewTeam();
        int originalTeamId = testTeam.getId();
        teamDao.add(testTeam);
        assertNotEquals(originalTeamId,testTeam.getId());
    }

    @Test
    public void existingTeamCanBeFoundById() {
        Team testTeam = setupNewTeam();
        teamDao.add(testTeam);
        Team foundTeam = teamDao.findById(testTeam.getId());
        assertEquals(testTeam, foundTeam);
    }

    @Test
    public void noTeamsAreFound() throws Exception {
        List<Team> allTeams = teamDao.getAll();
        assertEquals(0, allTeams.size());
    }

    @Test
    public void getAll_getsAllTeams_2() {
        Team testTeam = setupNewTeam();
        Team testTeam2 = new Team("Hawks", "Also rockers");
        teamDao.add(testTeam);
        teamDao.add(testTeam2);
        List<Team> allTeams = teamDao.getAll();
        assertEquals(2, allTeams.size());
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}