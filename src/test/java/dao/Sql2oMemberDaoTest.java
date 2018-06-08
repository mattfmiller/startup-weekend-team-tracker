package dao;

import models.Member;
import models.Team;
import org.junit.*;
import org.sql2o.*;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oMemberDaoTest {
    private Sql2oMemberDao memberDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        memberDao = new Sql2oMemberDao(sql2o);
        conn = sql2o.open();
    }

    public Member setupNewMember(){
        return new Member("Bill", "Bass", 1);
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingMemberSetsId() {
        Member testMember = setupNewMember();
        int originalMemberId = testMember.getId();
        memberDao.add(testMember);
        assertNotEquals(originalMemberId, testMember.getId());
    }

    @Test
    public void existingMemberCanBeFoundById() {
        Member testMember = setupNewMember();
        memberDao.add(testMember);
        Member foundMember = memberDao.findById(testMember.getId());
        assertEquals(testMember, foundMember);
    }

    @Test
    public void getAllMembersByTeamId() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void deleteByTeamId() {
    }
}