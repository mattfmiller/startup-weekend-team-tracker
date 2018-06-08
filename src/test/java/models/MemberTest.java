package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {

    public Member setupNewMember() {
        return new Member("Bill", "Bass", 1);
    }

    @Test
    public void newMemberObjectIsInstantiatedCorrectly_true() throws Exception {
        Member testMemeber = setupNewMember();
        assertTrue(testMemeber instanceof Member);
    }

//    @Test
//    public void getId() {
//        Member testMemeber = setupNewMember();
//    }

    @Test
    public void getName_getsNameCorrectly_bill() {
        Member testMemeber = setupNewMember();
        assertEquals("Bill", testMemeber.getName());
    }

    @Test
    public void setName_setsNameCorrectly_scotty() {
        Member testMemeber = setupNewMember();
        testMemeber.setName("Scotty");
        assertEquals("Scotty", testMemeber.getName());
    }

    @Test
    public void getSkill_getsSkillCorrectly_bass() {
        Member testMemeber = setupNewMember();
        assertEquals("Bass", testMemeber.getSkill());
    }

    @Test
    public void setSkill_setsSkillCorrectly_guitar() {
        Member testMemeber = setupNewMember();
        testMemeber.setSkill("Guitar");
        assertEquals("Guitar", testMemeber.getSkill());
    }

    @Test
    public void getTeamId() {
        Member testMemeber = setupNewMember();
        assertEquals(1, testMemeber.getTeamId());
    }

    @Test
    public void setTeamId() {
        Member testMemeber = setupNewMember();
        testMemeber.setTeamId(2);
        assertEquals(2, testMemeber.getTeamId());
    }

}