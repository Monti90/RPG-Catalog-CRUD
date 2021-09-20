package wasko.collectionmanager.rpgcollection.services;

import wasko.collectionmanager.rpgcollection.dto.GamePublisher;
import wasko.collectionmanager.rpgcollection.entities.GamePublisherEntity;

import java.util.List;

public interface GamePublisherService {
    GamePublisherEntity addPublisher(GamePublisher publisher);
    GamePublisherEntity updatePublisher(GamePublisher publisher, Long id);
    List<GamePublisher> getPublishers();
    GamePublisherEntity findPublisherById(Long id);
    void deletePublisher(Long id);
}
