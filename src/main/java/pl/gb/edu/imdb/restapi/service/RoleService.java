package pl.gb.edu.imdb.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gb.edu.imdb.restapi.model.Appearance;
import pl.gb.edu.imdb.restapi.repository.MovieResource;
import pl.gb.edu.imdb.restapi.repository.RoleResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    private RoleResource roleResource;
    private MovieResource movieResource;

    @Autowired
    public RoleService(RoleResource roleResource, MovieResource movieResource) {
        this.roleResource = roleResource;
        this.movieResource = movieResource;
    }

    public List<Map<String, Object>> getRolesByActorId(Long actorId) {
        List<Map<String, Object>> appearances = new ArrayList<>();
        roleResource.findRolesByActorId(actorId).forEach(role -> {
            Long movieId = role.getMovieId();
            String movieName = movieResource.findMovieById(role.getMovieId()).getTitle();
            String character = role.getCharacter();
            appearances.add(new Appearance(movieId, movieName, character).getAppearance());
        });
        return appearances;

    }
}
