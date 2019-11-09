package pl.gb.edu.imdb.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.gb.edu.imdb.client.model.Actor;
import pl.gb.edu.imdb.client.model.Appearance;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ActorClientService {

    @Value("${client.actor.resource}")
    private String actorResource;

    @Value("${spring.security.user.name}")
    private String user;

    @Value("${spring.security.user.password}")
    private String password;

    private RestTemplate restTemplate;

    @Autowired
    public ActorClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Actor> getActors(int page, int pageSize) {
        ServiceSecurity.authenticateService(user, password, restTemplate);
        String apiUrl = actorResource + "/?page=" + page + "&page_size=" + pageSize;
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(apiUrl, Actor[].class))).collect(Collectors.toList());
    }

    public Actor getActor(Long actorId) {
        ServiceSecurity.authenticateService(user, password, restTemplate);
        String apiUrl = actorResource + "/" + actorId;
        return restTemplate.getForObject(apiUrl, Actor.class);
    }

    public List<Appearance> getActorAppearance(Long actorId) {
        ServiceSecurity.authenticateService(user, password, restTemplate);
        String apiUrl = actorResource + "/" + actorId + "/appearances";
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(apiUrl, Appearance[].class))).collect(Collectors.toList());
    }
}
