

import models.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            ArrayList<Place> places = Place.getAll();
            model.put("places", places);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());


        get("/success", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/form", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String name = req.queryParams("name");
            String date = req.queryParams("date");
            Place place = new Place(name);
            place.setDate(date);

            model.put("place", place);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/places/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String id = req.params("id");

            Place place = Place.getElementById(Integer.parseInt(id));
            model.put("place", place);

            return new ModelAndView(model, "place.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
