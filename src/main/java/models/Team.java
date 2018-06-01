package models;

import java.util.ArrayList;

public class Team {
    private ArrayList<String> members = new ArrayList<>();
    private String name;
    private String description;
    private int id;
    private ArrayList<Team> teamsList = new ArrayList<>();

    public Team() {
        this.name = null;
        this.description = null;
        teamsList.add(this);
        this.id = teamsList.size();
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
