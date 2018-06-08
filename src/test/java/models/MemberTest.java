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
    public void getName() {
        Member testMemeber = setupNewMember();
        assertEquals("Bill", testMemeber.getName());
    }

    @Test
    public void setName() {
        Member testMemeber = setupNewMember();
        testMemeber.setName("Scotty");
        assertEquals("Scotty", testMemeber.getName());
    }

    @Test
    public void getDescription() {
        Member testMemeber = setupNewMember();

    }

    @Test
    public void setDescription() {
        Member testMemeber = setupNewMember();
    }

    @Test
    public void getTeamId() {
        Member testMemeber = setupNewMember();
    }

    @Test
    public void setTeamId() {
        Member testMemeber = setupNewMember();
    }
}