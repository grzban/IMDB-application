package pl.gb.edu.imdb.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gb.edu.imdb.client.service.MovieClientService;

@Controller
@RequestMapping(value = "/movie")
public class MovieClientController {
    private MovieClientService movieClientService;

    @Autowired
    public MovieClientController(MovieClientService movieClientService) {
        this.movieClientService = movieClientService;
    }

    @GetMapping("")
    public String showMovies(Model model) {
        model.addAttribute("movies", movieClientService.getMovies(0, 10));
        return "movies";
    }

    @GetMapping("/{id}")
    public String showMovies(Model model, @PathVariable("id") Long id) {
        model.addAttribute("movie", movieClientService.getMovie(id));
        return "movie";
    }
}
