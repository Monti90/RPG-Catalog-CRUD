package wasko.collectionmanager.rpgcollection.mappers.impl;

import org.springframework.stereotype.Component;
import wasko.collectionmanager.rpgcollection.dto.GamePublisher;
import wasko.collectionmanager.rpgcollection.entities.GamePublisherEntity;
import wasko.collectionmanager.rpgcollection.mappers.PublisherMapper;

@Component
public class PublisherMapperImpl implements PublisherMapper {

    public GamePublisher mapToPublisher(GamePublisherEntity gamePublisherEntity) {
        return GamePublisher.builder()
                .id(gamePublisherEntity.getId())
                .name(gamePublisherEntity.getName())
                .website(gamePublisherEntity.getWebsite())
                .imageUrl(gamePublisherEntity.getImageUrl())
                .build();
    }


    public GamePublisherEntity mapToPublisherEntity(GamePublisher gamePublisher) {
        return GamePublisherEntity.builder()
                .name(gamePublisher.getName())
                .website(gamePublisher.getWebsite())
                .imageUrl(gamePublisher.getImageUrl())
                .build();
    }
}
