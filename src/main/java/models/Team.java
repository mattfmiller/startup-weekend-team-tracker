package models;

import java.util.ArrayList;

public class Team {
    private ArrayList<String> members = new ArrayList<>();
    private String name;
    private String description;
    private int id;
    private ArrayList<Team> teamsList = new ArrayList<>();

    public Team() {
        teamsList.add(this);
        this.id = teamsList.size();
    }

    public ArrayList<String> getMembers() {
        return members;
    }
}
