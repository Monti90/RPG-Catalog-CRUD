package wasko.collectionmanager.rpgcollection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wasko.collectionmanager.rpgcollection.entities.UserEntity;
import wasko.collectionmanager.rpgcollection.view.UserWithoutPasswordView;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByuserName(String username);
    <T> T findByUserID(Long id, Class<T> type);

}
