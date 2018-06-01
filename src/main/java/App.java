import java.util.*;

import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Team> teams = Team.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/info", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "info.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newteam-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String teamName = req.queryParams("name");
            String teamDescription = req.queryParams("description");
            String teamMembersString = req.queryParams("members");
            Team newTeam = new Team();
            newTeam.setName(teamName);
            newTeam.setDescription(teamDescription);
            List<String> teamMembersArray = Arrays.asList(teamMembersString.split("\\s*,\\s*"));
            for ( String teamMember : teamMembersArray ) {
                newTeam.addMember(teamMember);
            }
            System.out.println(newTeam.getMembers());
            model.put("teams", newTeam);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(req.params("id"));
            Team foundTeam = Team.findById(idOfTeamToFind);
            model.put("foundTeam", foundTeam);
            return new ModelAndView(model, "team-details.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id", (req, res) -> {
            String newTeamMember = req.queryParams("newTeamMember");
            int idOfTeamToFind = Integer.parseInt(req.params("id"));
            Team foundTeam = Team.findById(idOfTeamToFind);
            foundTeam.addMember(newTeamMember);
            res.redirect("/teams/" + idOfTeamToFind);
            return null;
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = Team.findById(idOfTeamToEdit);
            model.put("editTeam", editTeam);
            return new ModelAndView(model, "newteam-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (req, res) -> {
            String newName = req.queryParams("name");
            String newDescription = req.queryParams("description");
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = Team.findById(idOfTeamToEdit);
            editTeam.setName(newName);
            editTeam.setDescription(newDescription);
            res.redirect("/teams/" + idOfTeamToEdit);
            return null;
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/members/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = Team.findById(idOfTeamToEdit);
            model.put("editTeam", editTeam);
            return new ModelAndView(model, "delete-members.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/members/delete", (req, res) -> {
            String memberToRemove = req.queryParams("memberToRemove");
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = Team.findById(idOfTeamToEdit);
            editTeam.removeMember(memberToRemove);
            res.redirect("/teams/" + idOfTeamToEdit);
            return null;
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/delete", (req, res) -> {
            int idOfTeamToDelete = Integer.parseInt(req.params("id"));
            Team teamToDelete = Team.findById(idOfTeamToDelete);
            teamToDelete.deleteTeam();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }
}
