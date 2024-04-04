package ma.tpsj2ee.user_role.repositories;

import ma.tpsj2ee.user_role.entities.Role;
import ma.tpsj2ee.user_role.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository //Component de la couche dao
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
