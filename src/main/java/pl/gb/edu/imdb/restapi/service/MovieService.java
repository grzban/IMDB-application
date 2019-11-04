package pl.gb.edu.imdb.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.gb.edu.imdb.restapi.model.Movie;
import pl.gb.edu.imdb.restapi.resource.MovieResource;

import java.util.List;

@Service
public class MovieService {
    private MovieResource movieResource;

    @Autowired
    public MovieService(MovieResource movieResource) {
        this.movieResource = movieResource;
    }

    public List<Movie> getMoviePage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return movieResource.findMoviesBy(pageable).getContent();
    }

    public Movie getMovieById(Long id) {
        return movieResource.findById(id).orElse(null);
    }
}
