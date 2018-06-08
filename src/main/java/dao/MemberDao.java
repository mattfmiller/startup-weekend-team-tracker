package dao;

import models.Member;

import java.util.List;

public interface MemberDao {
    // LIST
    List<Member> getAllMembersByTeamId(int teamId);

    // CREATE
    void add(Member member);

    // READ
    Member findById(int id);

    // UPDATE
    void update(int id, String name, String skill, int teamId);

    // DELETE
    void deleteById(int id);
    void deleteByTeamId(int teamId);
}
