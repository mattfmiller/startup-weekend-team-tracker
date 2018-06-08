import java.util.*;

import dao.Sql2oMemberDao;
import dao.Sql2oTeamDao;
import models.Team;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        String connectionString = "jdbc:h2:~/hackathon.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oTeamDao teamDao = new Sql2oTeamDao(sql2o);
        Sql2oMemberDao memberDao = new Sql2oMemberDao(sql2o);

        //get: show all teams
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Team> teams = teamDao.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show info page
        get("/info", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "info.hbs");
        }, new HandlebarsTemplateEngine());

        //get:show new team form
        get("/teams/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new team form
        post("/teams", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String teamName = req.queryParams("name");
            String teamDescription = req.queryParams("description");
            Team newTeam = new Team(teamName, teamDescription);
            teamDao.add(newTeam);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show team details
        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(req.params("id"));
            Team foundTeam = teamDao.findById(idOfTeamToFind);
            model.put("foundTeam", foundTeam);
            return new ModelAndView(model, "team-details.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new members form
//        post("/teams/:id", (req, res) -> {
//            String newTeamMember = req.queryParams("newTeamMember");
//            int idOfTeamToFind = Integer.parseInt(req.params("id"));
//            Team foundTeam = Team.findById(idOfTeamToFind);
//            foundTeam.addMember(newTeamMember);
//            res.redirect("/teams/" + idOfTeamToFind);
//            return null;
//        }, new HandlebarsTemplateEngine());

        //get:show form to update team
        get("/teams/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = teamDao.findById(idOfTeamToEdit);
            model.put("editTeam", editTeam);
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process for to update team
        post("/teams/:id/edit", (req, res) -> {
            String newName = req.queryParams("name");
            String newDescription = req.queryParams("description");
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            teamDao.update(idOfTeamToEdit, newName, newDescription);
            res.redirect("/teams/" + idOfTeamToEdit);
            return null;
        }, new HandlebarsTemplateEngine());
//
//        get("/teams/:id/members/delete", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
//            Team editTeam = Team.findById(idOfTeamToEdit);
//            model.put("editTeam", editTeam);
//            return new ModelAndView(model, "delete-members.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/teams/:id/members/delete", (req, res) -> {
//            String memberToRemove = req.queryParams("memberToRemove");
//            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
//            Team editTeam = Team.findById(idOfTeamToEdit);
//            editTeam.removeMember(memberToRemove);
//            res.redirect("/teams/" + idOfTeamToEdit);
//            return null;
//        }, new HandlebarsTemplateEngine());
//
//        get("/teams/:id/delete", (req, res) -> {
//            int idOfTeamToDelete = Integer.parseInt(req.params("id"));
//            Team teamToDelete = Team.findById(idOfTeamToDelete);
//            teamToDelete.deleteTeam();
//            res.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());

    }
}
