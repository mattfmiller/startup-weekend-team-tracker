package models;

import java.util.Objects;

public class Member {
    private int id;
    private String name;
    private String description;
    private int teamId;

    public Member(String name, String description, int teamId) {
        this.name = name;
        this.description = description;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                Objects.equals(description, member.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, teamId);
    }
}
