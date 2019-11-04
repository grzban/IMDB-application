/*
package pl.gb.edu.imdb.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.gb.edu.imdb.restapi.model.Movie;
import pl.gb.edu.imdb.restapi.service.MovieService;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieRestController {
    private MovieService movieService;

    @Autowired
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public List<Movie> getMovies(@RequestParam("page") Integer page, @RequestParam("page_size") Integer size) {
        return movieService.getMoviePage(page, size);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }
}
*/
