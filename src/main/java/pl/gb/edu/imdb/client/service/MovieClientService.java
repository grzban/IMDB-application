package pl.gb.edu.imdb.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.gb.edu.imdb.client.model.Actor;
import pl.gb.edu.imdb.client.model.Movie;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieClientService {

    @Value("${client.movie.resource}")
    private String movieResource;

    @Value("${spring.security.user.name}")
    private String user;

    @Value("${spring.security.user.password}")
    private String password;

    private RestTemplate restTemplate;

    @Autowired
    public MovieClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getMovies(int page, int pageSize) {
        ServiceSecurity.authenticateService(user, password, restTemplate);
        String apiUrl = movieResource + "/?page=" + page + "&page_size=" + pageSize;
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(apiUrl, Movie[].class))).collect(Collectors.toList());
    }

    public Movie getMovie(Long movieId) {
        ServiceSecurity.authenticateService(user, password, restTemplate);
        String apiUrl = movieResource + "/" + movieId;
        return restTemplate.getForObject(apiUrl, Movie.class);
    }
}
