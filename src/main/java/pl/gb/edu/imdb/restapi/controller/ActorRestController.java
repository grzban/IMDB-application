package pl.gb.edu.imdb.restapi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gb.edu.imdb.restapi.model.Actor;
import pl.gb.edu.imdb.restapi.model.Role;
import pl.gb.edu.imdb.restapi.service.ActorService;
import pl.gb.edu.imdb.restapi.service.RoleService;

import java.util.List;

@Controller
@RequestMapping(value = "/v1/actors", produces = "application/json")
public class ActorRestController {
    private ActorService actorService;
    private RoleService roleService;
    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    public ActorRestController(ActorService actorService, RoleService roleService) {
        this.actorService = actorService;
        this.roleService = roleService;
    }

    @GetMapping(value = {"/", "?page={page}&size={size}"}, produces = "application/json")
    public String getActors(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        logger.info("Test logger " + page);
//        return actorService.getActors(page, size).stream().collect(Collectors.toList());
        return "index";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Actor> getActorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(actorService.getActorById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/appearances", produces = "application/json")
    public ResponseEntity<List<Role>> showActorRoles(@PathVariable("id") Long id) {
        return new ResponseEntity<>(roleService.getRolesByActorId(id), HttpStatus.OK);
    }
}
