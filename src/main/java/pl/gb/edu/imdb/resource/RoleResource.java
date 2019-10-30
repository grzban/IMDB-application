package pl.gb.edu.imdb.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.gb.edu.imdb.model.Role;

import java.util.List;

@SuppressWarnings("unused")
public interface RoleResource extends PagingAndSortingRepository<Role, Long> {
    Page<Role> findRolesBy(Pageable pageable);
    List<Role> findRolesByActorId(Long actorId);
    List<Role> findRolesByMovieId(Long movieId);
}
