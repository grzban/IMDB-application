package pl.gb.edu.imdb.restapi.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.gb.edu.imdb.restapi.model.Movie;

public interface MovieResource extends PagingAndSortingRepository<Movie, Long> {
    Page<Movie> findMoviesBy(Pageable pageable);
}
