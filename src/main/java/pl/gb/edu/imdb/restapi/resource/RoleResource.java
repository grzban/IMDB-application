package pl.gb.edu.imdb.restapi.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.gb.edu.imdb.restapi.model.Role;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface RoleResource extends PagingAndSortingRepository<Role, Long> {
    Page<Role> findRolesBy(Pageable pageable);
    List<Role> findRolesByActorId(Long actorId);
    List<Role> findRolesByMovieId(Long movieId);
}
