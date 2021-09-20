package wasko.collectionmanager.rpgcollection.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wasko.collectionmanager.rpgcollection.dto.User;
import wasko.collectionmanager.rpgcollection.entities.UserEntity;
import wasko.collectionmanager.rpgcollection.exceptions.UserNotFoundException;
import wasko.collectionmanager.rpgcollection.mappers.UserMapper;
import wasko.collectionmanager.rpgcollection.repositories.UserRepository;
import wasko.collectionmanager.rpgcollection.services.UserService;
import wasko.collectionmanager.rpgcollection.view.UserWithoutPasswordView;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserEntity addUser(User user)
    {
        return userRepository.save(userMapper.mapToUserEntity(user));
    }
    @Override
    public UserEntity updateUser(User user, Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID: "+id+" not found"));
        userEntity = userMapper.mapToUserEntity(user);
        userEntity.setUserID(id);
        return userRepository.save(userEntity);
    }
    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream()
                .map(userEntity -> userMapper.mapToUser(userEntity))
                .collect(Collectors.toList());
    }
    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public UserWithoutPasswordView findUserViewById(Long id) {
        return userRepository.findByUserID(id, UserWithoutPasswordView.class);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.delete(findUserById(id));
    }
}
