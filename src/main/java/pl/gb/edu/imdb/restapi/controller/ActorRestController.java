package pl.gb.edu.imdb.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gb.edu.imdb.restapi.model.Actor;
import pl.gb.edu.imdb.restapi.model.Role;
import pl.gb.edu.imdb.restapi.service.ActorService;
import pl.gb.edu.imdb.restapi.service.RoleService;

import java.util.List;

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

    @GetMapping("?page={page}&size={size}")
    public ResponseEntity<Page<Actor>> getActors(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return new ResponseEntity<>(actorService.getActors(page, size), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(actorService.getActorById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/appearances")
    public ResponseEntity<List<Role>> showActorRoles(@PathVariable("id") Long id) {
        return new ResponseEntity<>(roleService.getRolesByActorId(id), HttpStatus.OK);
    }
}
