package com.tnologia;

import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        staticFileLocation("/public");
        port(1234);


        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(Main.class, "/templates/");
        FreeMarkerEngine freeMarkerEngine= new FreeMarkerEngine(configuration);

        get("/", (request,response)-> {
            Map<String, Object> attributes = new HashMap<>();

            return new ModelAndView(attributes, "/index.ftl");
        }, freeMarkerEngine );
    }
}
