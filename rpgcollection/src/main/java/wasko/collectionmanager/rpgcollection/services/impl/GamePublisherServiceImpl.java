package wasko.collectionmanager.rpgcollection.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wasko.collectionmanager.rpgcollection.dto.GamePublisher;
import wasko.collectionmanager.rpgcollection.entities.GamePublisherEntity;
import wasko.collectionmanager.rpgcollection.exceptions.GameNotFoundException;
import wasko.collectionmanager.rpgcollection.exceptions.GamePublisherNotFoundException;
import wasko.collectionmanager.rpgcollection.mappers.PublisherMapper;
import wasko.collectionmanager.rpgcollection.repositories.GamePublisherRepository;
import wasko.collectionmanager.rpgcollection.services.GamePublisherService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GamePublisherServiceImpl implements GamePublisherService {

    private final GamePublisherRepository gamePublisherRepository;
    private final PublisherMapper publisherMapper;

    public GamePublisherEntity addPublisher(GamePublisher publisher){  return gamePublisherRepository.save(publisherMapper.mapToPublisherEntity(publisher)); }

    public GamePublisherEntity updatePublisher(GamePublisher publisher, Long id) {
        GamePublisherEntity publisherEntity = gamePublisherRepository.findById(id)
                .orElseThrow(() -> new GamePublisherNotFoundException("Publisher with ID: "+id+" not found"));
        publisherEntity = publisherMapper.mapToPublisherEntity(publisher);
        publisherEntity.setId(id);
        return gamePublisherRepository.save(publisherEntity); }

    public List<GamePublisher> getPublishers(){ return gamePublisherRepository.findAll().stream()
            .map(gamePublisherEntity -> publisherMapper.mapToPublisher(gamePublisherEntity))
            .collect(Collectors.toList());}

    public GamePublisherEntity findPublisherById(Long id){
        return gamePublisherRepository.findById(id)
                .orElseThrow(()-> new GameNotFoundException("Publisher not found"));
    }
    public void deletePublisher(Long id) { gamePublisherRepository.deleteById(id); }

}
