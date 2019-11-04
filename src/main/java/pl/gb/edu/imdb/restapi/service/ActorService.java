package pl.gb.edu.imdb.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.gb.edu.imdb.restapi.model.Actor;
import pl.gb.edu.imdb.restapi.repository.ActorResource;

@Service
public class ActorService {

    private ActorResource actorResource;

    @Autowired
    public ActorService(ActorResource actorResource) {
        this.actorResource = actorResource;
    }

    public Page<Actor> getActors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return actorResource.findActorsBy(pageable);
    }

    public Actor getActorById(Long id) {
        return actorResource.findById(id).orElse(null);
    }
}
