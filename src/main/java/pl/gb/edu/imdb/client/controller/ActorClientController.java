package pl.gb.edu.imdb.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActorClientController {
    @GetMapping("/actors")
    public String index(Model model) {

        return "index";
    }
}
