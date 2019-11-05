package pl.gb.edu.imdb.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActorClientController {
    @GetMapping("/actor")
    public String index() {
        return "actor";
    }
}
