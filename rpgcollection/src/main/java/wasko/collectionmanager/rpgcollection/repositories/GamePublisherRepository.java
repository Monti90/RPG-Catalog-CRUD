package wasko.collectionmanager.rpgcollection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wasko.collectionmanager.rpgcollection.entities.GamePublisherEntity;

import java.util.Optional;

public interface GamePublisherRepository extends JpaRepository<GamePublisherEntity, Long> {

}
