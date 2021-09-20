package wasko.collectionmanager.rpgcollection.mappers.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import wasko.collectionmanager.rpgcollection.dto.Game;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.AuthorDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.GenreDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.CategoryDictionaryEntity;
import wasko.collectionmanager.rpgcollection.mappers.GameMapper;
import wasko.collectionmanager.rpgcollection.services.DictionaryService;
import wasko.collectionmanager.rpgcollection.services.GamePublisherService;
import wasko.collectionmanager.rpgcollection.services.UserService;

@AllArgsConstructor
@Component
public class GameMapperImpl implements GameMapper {

    private GamePublisherService gamePublisherService;
    private UserService userService;

    public Game mapToGame(GameEntity gameEntity){
        return Game.builder()
                .id(gameEntity.getId())
                .name(gameEntity.getName())
                .description(gameEntity.getDescription())
                .price(gameEntity.getPrice())
                .imageUrl(gameEntity.getImageUrl())
                .releaseDate(gameEntity.getReleaseDate())
                .publisherID(gameEntity.getGamePublisher().getId())
                .userID(gameEntity.getUser().getUserID())
                .author(gameEntity.getAuthor().getValue())
                .category(gameEntity.getCategory().getValue())
                .genre(gameEntity.getGenre().getValue())
                .build();
    }

 public GameEntity mapToGameEntity(Game game, AuthorDictionaryEntity author, CategoryDictionaryEntity category, GenreDictionaryEntity genre){
        return GameEntity.builder()
                .name(game.getName())
                .description(game.getDescription())
                .price(game.getPrice())
                .imageUrl(game.getImageUrl())
                .releaseDate(game.getReleaseDate())
                .gamePublisher(gamePublisherService.findPublisherById(game.getPublisherID()))
                .user(userService.findUserById(game.getUserID()))
                .author(author)
                .category(category)
                .genre(genre)
                .build();
    }

}
