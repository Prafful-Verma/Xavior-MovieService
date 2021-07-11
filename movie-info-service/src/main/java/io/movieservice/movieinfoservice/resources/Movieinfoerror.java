package io.movieservice.movieinfoservice.resources;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Movieinfoerror implements ErrorController {
    
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error in Movie Info Service Service !";
    }
}
