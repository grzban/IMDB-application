package pl.gb.edu.imdb.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Appearance {
    private Long movie_id;
    private String movie_name;
    private String character_name;
}
