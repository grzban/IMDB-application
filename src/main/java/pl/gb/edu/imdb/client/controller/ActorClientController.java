package pl.gb.edu.imdb.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gb.edu.imdb.client.service.ActorClientService;

@Controller
@RequestMapping(value = "/actor")
public class ActorClientController {
    private ActorClientService actorClientService;

    @Autowired
    public ActorClientController(ActorClientService actorClientService) {
        this.actorClientService = actorClientService;
    }

    @GetMapping("")
    public String showActors(Model model) {
        model.addAttribute("actors", actorClientService.getActors(0, 5));
        return "actors";
    }

    @GetMapping("/{id}")
    public String showActor(@PathVariable("id") Long actorId, Model model) {
        model.addAttribute("actor", actorClientService.getActor(actorId));
        model.addAttribute("appearances", actorClientService.getActorAppearance(actorId));
        return "actor";
    }

}
