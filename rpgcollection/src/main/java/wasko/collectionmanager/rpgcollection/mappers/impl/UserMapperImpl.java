package wasko.collectionmanager.rpgcollection.mappers.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import wasko.collectionmanager.rpgcollection.dto.User;
import wasko.collectionmanager.rpgcollection.entities.UserEntity;
import wasko.collectionmanager.rpgcollection.entities.enums.Role;
import wasko.collectionmanager.rpgcollection.mappers.UserMapper;
@Component
@AllArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User mapToUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getUserID())
                .userName(userEntity.getUserName())
                .userPassword(userEntity.getUserPassword())
                .email(userEntity.getEmail())
                .role(userEntity.getRole().toString()).build();
    }

    @Override
    public UserEntity mapToUserEntity(User user) {
        return UserEntity.builder()
                .userName(user.getUserName())
                .userPassword(passwordEncoder.encode(user.getUserPassword()))
                .email(user.getEmail())
                .role(Role.valueOf(user.getRole())).build();
    }
}
