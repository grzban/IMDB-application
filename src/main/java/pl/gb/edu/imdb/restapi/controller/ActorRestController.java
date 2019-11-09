package pl.gb.edu.imdb.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.gb.edu.imdb.restapi.model.Actor;
import pl.gb.edu.imdb.restapi.service.ActorService;
import pl.gb.edu.imdb.restapi.service.RoleService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/actors")
public class ActorRestController {
    private ActorService actorService;
    private RoleService roleService;

    @Autowired
    public ActorRestController(ActorService actorService, RoleService roleService) {
        this.actorService = actorService;
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public List<Actor> getActors(@RequestParam("page") Integer page, @RequestParam("page_size") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return actorService.getActors(pageable);
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable("id") Long id) {
        return actorService.getActorById(id);
    }

    @GetMapping("/{id}/appearances")
    public List<Map<String, Object>> showActorRoles(@PathVariable("id") Long id) {
        return roleService.getRolesByActorId(id);
    }
}
