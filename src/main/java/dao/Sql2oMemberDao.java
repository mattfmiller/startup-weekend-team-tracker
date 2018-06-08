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
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM members WHERE teamId = :teamId")
                    .addParameter("teamId", teamId)
                    .executeAndFetch(Member.class);
        }
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
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM members WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Member.class);
        }
    }

    @Override
    public void update(int id, String name, String skill, int teamId) {
        String sql = "UPDATE members SET (name, skill, teamId) = (:name, :skill, :teamId) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("skill", skill)
                    .addParameter("teamId", teamId)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from members WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteByTeamId(int teamId) {
        String sql = "DELETE from members WHERE teamId=:teamId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("teamId", teamId)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
