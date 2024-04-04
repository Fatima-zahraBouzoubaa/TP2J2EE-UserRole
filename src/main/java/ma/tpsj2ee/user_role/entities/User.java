package ma.tpsj2ee.user_role.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
//Ajout de Table n'est pas necessaire, sert a nommer la table dans la bd
@Table(name="USERS")
@Data
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name="USER_NAME",unique = true, length = 20)
    private String username;
    private String password;
    //fetchType.Eager permet de charger automatiquement les roles en meme temps que le user
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Role> roles= new ArrayList<>();//eviter un nullpointer exception

}
