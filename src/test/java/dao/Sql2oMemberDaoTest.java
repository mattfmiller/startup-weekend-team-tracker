package dao;

import models.Member;
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
    public void getAllMembersByTeamId_getsAllMeberbersOfTeam() {
        Member testMember = setupNewMember();
        Member testMember2 = new Member("Scotty", "Guitar", 1);
        Member testMember3 = new Member("DJ", "Drums", 2);
        memberDao.add(testMember);
        memberDao.add(testMember2);
        memberDao.add(testMember3);
        List<Member> allMembersOfTeam1 = memberDao.getAllMembersByTeamId(1);
        assertEquals(2, allMembersOfTeam1.size());
        assertTrue(allMembersOfTeam1.contains(testMember));
        assertFalse(allMembersOfTeam1.contains(testMember3));
    }

    @Test
    public void update_updatesMember() {
        Member testMember = setupNewMember();
        memberDao.add(testMember);
        int id = testMember.getId();
        memberDao.update(id, "Scotty", "Guitar", 2);
        Member updatedMember = memberDao.findById(id);
        assertEquals("Scotty", updatedMember.getName());
        assertEquals("Guitar", updatedMember.getSkill());
        assertEquals(2, updatedMember.getTeamId());
    }

    @Test
    public void deleteById() {
        Member testMember = setupNewMember();
        Member testMember2 = new Member("Scotty", "Guitar", 1);
        Member testMember3 = new Member("DJ", "Drums", 1);
        memberDao.add(testMember);
        memberDao.add(testMember2);
        memberDao.add(testMember3);
        memberDao.deleteById(2);
        List<Member> allMembersOfTeam1 = memberDao.getAllMembersByTeamId(1);
        assertEquals(2, allMembersOfTeam1.size());
        assertTrue(allMembersOfTeam1.contains(testMember));
        assertFalse(allMembersOfTeam1.contains(testMember2));
    }

    @Test
    public void deleteByTeamId_deletesAllMembersWithGivenTeamId() {
        Member testMember = setupNewMember();
        Member testMember2 = new Member("Scotty", "Guitar", 1);
        Member testMember3 = new Member("DJ", "Drums", 2);
        memberDao.add(testMember);
        memberDao.add(testMember2);
        memberDao.add(testMember3);
        memberDao.deleteByTeamId(1);
        List<Member> allMembersOfTeam1 = memberDao.getAllMembersByTeamId(1);
        List<Member> allMembersOfTeam2 = memberDao.getAllMembersByTeamId(2);
        assertEquals(0, allMembersOfTeam1.size());
        assertEquals(1,allMembersOfTeam2.size());
    }
}