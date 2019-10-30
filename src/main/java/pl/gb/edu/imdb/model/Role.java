package pl.gb.edu.imdb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long movieId;

    @Column
    private long actorId;

    @Column(name = "character", columnDefinition = "text")
    private String character;
}
