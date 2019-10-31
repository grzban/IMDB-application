package pl.gb.edu.imdb.restapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    private long id;
    @Column(columnDefinition = "text")
    private String title;
    @Column
    private String year;
}
