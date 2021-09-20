package wasko.collectionmanager.rpgcollection.mappers;

import wasko.collectionmanager.rpgcollection.dto.GamePublisher;
import wasko.collectionmanager.rpgcollection.entities.GamePublisherEntity;

public interface PublisherMapper {

    GamePublisher mapToPublisher(GamePublisherEntity gamePublisherEntity);

    GamePublisherEntity mapToPublisherEntity(GamePublisher gamePublisher);
}
