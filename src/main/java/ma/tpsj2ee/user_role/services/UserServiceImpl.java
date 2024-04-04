package ma.tpsj2ee.user_role.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.tpsj2ee.user_role.entities.Role;
import ma.tpsj2ee.user_role.entities.User;
import ma.tpsj2ee.user_role.repositories.RoleRepository;
import ma.tpsj2ee.user_role.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor //Ne pas ajouter un constructeur
// sans parametres pour avoir l'injection de dependances
public class UserServiceImpl implements UserService {
    //@Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user=this.findUserByUserName(username);
        Role role=this.findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);
        //n'est pas obligatoire puisqu'il y a l'utilisation de
        // @Transactional qui effectue un commit en fin de transaction


    }

    @Override
    public User authenticate(String username, String password) {
       User user=userRepository.findByUsername(username);
       if(user==null)throw new RuntimeException("Bad credentials");
       if(user.getPassword().equals(password)){
           return user;
       }
        throw new RuntimeException("Bad credentials");
    }
}
