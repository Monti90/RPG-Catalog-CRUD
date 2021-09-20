package wasko.collectionmanager.rpgcollection.services;

import wasko.collectionmanager.rpgcollection.dto.Game;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;

import java.util.List;

public interface GameService {
    GameEntity addGame(Game game);
    GameEntity updateGame(Game game, Long id);
    List<Game> getGames();
    Game findGameById(Long id);
    void deleteGame(Long id);
    List<Game> findGamesByPublisherId(Long id);
    List<Game> findGamesByUserId(Long id);
    List<Game> findGamesByAuthor(String author);
    List<Game> findGamesByGenre(String genre);
    List<Game> findGamesByCategory(String category);
}
