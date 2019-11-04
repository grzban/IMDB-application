package pl.gb.edu.imdb.restapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.gb.edu.imdb.restapi.model.Actor;

public interface ActorResource extends PagingAndSortingRepository<Actor, Long> {
    Page<Actor> findActorsBy(Pageable pageable);
}
