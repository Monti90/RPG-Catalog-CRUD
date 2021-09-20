package wasko.collectionmanager.rpgcollection.mappers;

import wasko.collectionmanager.rpgcollection.dto.Game;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.AuthorDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.GenreDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.CategoryDictionaryEntity;

public interface GameMapper {

    Game mapToGame(GameEntity gameEntity);
    GameEntity mapToGameEntity(Game game, AuthorDictionaryEntity author, CategoryDictionaryEntity type, GenreDictionaryEntity genre);

}
