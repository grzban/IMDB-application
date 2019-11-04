package pl.gb.edu.imdb.restapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.gb.edu.imdb.restapi.model.Movie;

public interface MovieResource extends PagingAndSortingRepository<Movie, Long> {
    Page<Movie> findMoviesBy(Pageable pageable);
}
