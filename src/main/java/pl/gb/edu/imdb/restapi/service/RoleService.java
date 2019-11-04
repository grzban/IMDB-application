package pl.gb.edu.imdb.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.gb.edu.imdb.restapi.model.Role;
import pl.gb.edu.imdb.restapi.repository.RoleResource;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class RoleService {
    private RoleResource roleResource;

    @Autowired
    public RoleService(RoleResource roleResource) {
        this.roleResource = roleResource;
    }

    public List<Role> getRolePage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return roleResource.findRolesBy(pageable).getContent();
    }

    public List<Role> getRolesByActorId(Long actorId) {
        return roleResource.findRolesByActorId(actorId);
    }
}
