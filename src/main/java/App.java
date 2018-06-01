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

    }
}
