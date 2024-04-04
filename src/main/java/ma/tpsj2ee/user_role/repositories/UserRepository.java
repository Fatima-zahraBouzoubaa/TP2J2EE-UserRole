package ma.tpsj2ee.user_role.repositories;

import ma.tpsj2ee.user_role.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);
}
