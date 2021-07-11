package io.movieservice.ratingsdataservice.resources;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ratingsdataerror implements ErrorController {
    
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error in Ratings Data Service !";
    }
}
