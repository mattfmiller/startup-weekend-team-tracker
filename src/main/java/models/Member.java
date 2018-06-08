package models;

import java.util.Objects;

public class Member {
    private int id;
    private String name;
    private String skill;
    private int teamId;

    public Member(String name, String skill, int teamId) {
        this.name = name;
        this.skill = skill;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                teamId == member.teamId &&
                Objects.equals(name, member.name) &&
                Objects.equals(skill, member.skill);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, skill, teamId);
    }

}
