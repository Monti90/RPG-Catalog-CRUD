package wasko.collectionmanager.rpgcollection.mappers;

import wasko.collectionmanager.rpgcollection.dto.User;
import wasko.collectionmanager.rpgcollection.entities.UserEntity;

public interface UserMapper {

    User mapToUser(UserEntity userEntity);
    UserEntity mapToUserEntity(User user);
}
