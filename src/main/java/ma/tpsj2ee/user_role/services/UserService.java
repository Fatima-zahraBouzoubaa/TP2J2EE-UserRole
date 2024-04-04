package ma.tpsj2ee.user_role.services;

import ma.tpsj2ee.user_role.entities.Role;
import ma.tpsj2ee.user_role.entities.User;


public interface UserService {
    User addNewUser (User user);
    Role addNewRole (Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String username, String password);
}
