package pl.gb.edu.imdb.restapi.model;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class Appearance {
    private Long movieId;
    private String movieName;
    private String character;

    public Appearance(Long movieId, String movieName, String character) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.character = character;
    }

    public Map<String, Object> getAppearance() {
        Map<String, Object> appearance = new LinkedHashMap<>();
        appearance.put("movie_id", movieId);
        appearance.put("movie_name", movieName);
        appearance.put("character_name", character);
        return appearance;
    }
}
