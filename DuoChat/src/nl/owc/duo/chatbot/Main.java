package nl.owc.duo.chatbot;

import spark.ModelAndView;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Spark.staticFileLocation("public_html");

        Spark.get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "index"));
        });

        Spark.get("/chat", (request, response) -> {

            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "chat-venster"));
        });

        Spark.post("/chat", (request, response) -> {
            String choice = request.queryParams("choice");
            if("jira".equals(choice)) {
                return "<div> Vul het  nummer in: </div>";
            } else if ("Testgeval".equals(choice)) {
                return "<div>Niveau: </div>";
            }
            return "<div>Default </div>";
        });

    }

}
