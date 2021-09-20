package wasko.collectionmanager.rpgcollection.services;

import wasko.collectionmanager.rpgcollection.dto.User;
import wasko.collectionmanager.rpgcollection.entities.UserEntity;
import wasko.collectionmanager.rpgcollection.view.UserWithoutPasswordView;

import java.util.List;

public interface UserService{

    UserEntity addUser(User user);
    UserEntity updateUser(User user, Long id);
    List<User> getUsers();
    UserEntity findUserById(Long id);
    UserWithoutPasswordView findUserViewById(Long id);
    void deleteUser(Long id);

}
