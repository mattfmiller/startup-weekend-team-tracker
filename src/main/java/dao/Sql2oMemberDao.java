package dao;

import models.Member;
import org.sql2o.*;

import java.util.List;

public class Sql2oMemberDao implements MemberDao {

    private final Sql2o sql2o;

    public Sql2oMemberDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Member> getAllMembersByTeamId(int teamId) {
        return null;
    }

    @Override
    public void add(Member member) {
        String sql = "INSERT INTO members (name, skill, teamId) VALUES (:name, :skill, :teamId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(member)
                    .executeUpdate()
                    .getKey();
            member.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public Member findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String name, String skill, int teamId) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteByTeamId(int teamId) {

    }

}
