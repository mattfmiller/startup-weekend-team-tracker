package dao;

import models.Team;
import org.junit.*;
import org.sql2o.*;

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
    public void getAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}