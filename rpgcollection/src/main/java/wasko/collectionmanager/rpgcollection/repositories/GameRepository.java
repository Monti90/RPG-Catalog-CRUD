package wasko.collectionmanager.rpgcollection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;
import wasko.collectionmanager.rpgcollection.entities.GamePublisherEntity;
import wasko.collectionmanager.rpgcollection.entities.UserEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.AuthorDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.GenreDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.CategoryDictionaryEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {

    List<GameEntity> findAllByGamePublisher(Optional<GamePublisherEntity> byId);

    List<GameEntity> findAllByUser(Optional<UserEntity> byId);

    List<GameEntity> findAllByAuthor(AuthorDictionaryEntity authorDictionaryEntity);

    List<GameEntity> findAllByGenre(GenreDictionaryEntity genreDictionaryEntity);

    List<GameEntity> findAllByCategory(CategoryDictionaryEntity categoryDictionaryEntity);
}
