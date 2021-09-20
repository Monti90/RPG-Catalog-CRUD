package wasko.collectionmanager.rpgcollection.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wasko.collectionmanager.rpgcollection.dto.Game;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.AuthorDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.GenreDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.CategoryDictionaryEntity;
import wasko.collectionmanager.rpgcollection.exceptions.GameNotFoundException;
import wasko.collectionmanager.rpgcollection.mappers.GameMapper;
import wasko.collectionmanager.rpgcollection.repositories.GamePublisherRepository;
import wasko.collectionmanager.rpgcollection.repositories.GameRepository;
import wasko.collectionmanager.rpgcollection.repositories.UserRepository;
import wasko.collectionmanager.rpgcollection.services.DictionaryService;
import wasko.collectionmanager.rpgcollection.services.GameService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final GamePublisherRepository publisherRepository;
    private final UserRepository userRepository;
    private final GameMapper gameMapper;
    private final DictionaryService dictionaryService;
    @Override
    public GameEntity addGame(Game game){
        AuthorDictionaryEntity aD =
                (AuthorDictionaryEntity) dictionaryService.findOrCreateValueByValueAndType(game.getAuthor(),"author");
        CategoryDictionaryEntity tD =
                (CategoryDictionaryEntity) dictionaryService.findOrCreateValueByValueAndType(game.getCategory(),"category");
        GenreDictionaryEntity gD =
                (GenreDictionaryEntity) dictionaryService.findOrCreateValueByValueAndType(game.getGenre(),"genre");

        return gameRepository.save(gameMapper.mapToGameEntity(game, aD, tD, gD));
    }
    @Override
    public List<Game> getGames(){ return (gameRepository
            .findAll()
            .stream()
            .map(gameEntity -> gameMapper.mapToGame(gameEntity))
            .collect(Collectors.toList()));
    }
    @Override
    public GameEntity updateGame(Game game, Long id){
        AuthorDictionaryEntity aD =
                (AuthorDictionaryEntity) dictionaryService.findOrCreateValueByValueAndType(game.getAuthor(),"author");
        CategoryDictionaryEntity tD =
                (CategoryDictionaryEntity) dictionaryService.findOrCreateValueByValueAndType(game.getCategory(),"category");
        GenreDictionaryEntity gD =
                (GenreDictionaryEntity) dictionaryService.findOrCreateValueByValueAndType(game.getGenre(),"genre");


        GameEntity gameEntity = gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException("Game with ID: "+id+" not found"));
           gameEntity = gameMapper.mapToGameEntity(game, aD, tD, gD);
           gameEntity.setId(id);
            return gameRepository.save(gameEntity);}

    @Override
    public Game findGameById(Long id){
        return gameMapper.mapToGame(gameRepository.findById(id)
                .orElseThrow(()-> new GameNotFoundException("Game not found")));

    }

    public void deleteGame(Long id){ gameRepository.deleteById(id);}

    @Override
    public List<Game> findGamesByPublisherId(Long id) {
        return gameRepository.findAllByGamePublisher(publisherRepository.findById(id)).stream()
                .map(gameEntity -> gameMapper.mapToGame(gameEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Game> findGamesByUserId(Long id) {
        return gameRepository.findAllByUser(userRepository.findById(id)).stream()
                .map(gameEntity -> gameMapper.mapToGame(gameEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Game> findGamesByAuthor(String author) {
        return gameRepository.findAllByAuthor((AuthorDictionaryEntity) dictionaryService.findByValueAndType(author, "author")).stream()
                .map(gameEntity -> gameMapper.mapToGame(gameEntity)).collect(Collectors.toList());
    }

    @Override
    public List<Game> findGamesByGenre(String genre) {
        return gameRepository.findAllByGenre((GenreDictionaryEntity) dictionaryService.findByValueAndType(genre, "genre")).stream()
                .map(gameEntity -> gameMapper.mapToGame(gameEntity)).collect(Collectors.toList());
    }

    @Override
    public List<Game> findGamesByCategory(String category) {
        return gameRepository.findAllByCategory((CategoryDictionaryEntity) dictionaryService.findByValueAndType(category, "category")).stream()
                .map(gameEntity -> gameMapper.mapToGame(gameEntity)).collect(Collectors.toList());
    }

}
