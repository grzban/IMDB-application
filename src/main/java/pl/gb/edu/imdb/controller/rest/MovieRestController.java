package pl.gb.edu.imdb.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pl.gb.edu.imdb.model.Movie;
import pl.gb.edu.imdb.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieRestController {
    private MovieService movieService;

    @Autowired
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("?page={page}&size={size}")
    public Page<Movie> getMovies(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return movieService.getMoviePage(page, size);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }
}
