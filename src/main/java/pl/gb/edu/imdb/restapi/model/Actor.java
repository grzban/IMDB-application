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
@Table(name = "actors")
public class Actor {
    @Id
    private long id;
    @Column
    private String name;
}
