package wasko.collectionmanager.rpgcollection.entities;

import lombok.*;
import wasko.collectionmanager.rpgcollection.entities.enums.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @SequenceGenerator(name="user_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private Long userID;
    @Column(unique = true)
    private String userName;
    private String userPassword;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
   //@OneToMany(mappedBy = "user")
   //private Set<GameEntity> game;

}
