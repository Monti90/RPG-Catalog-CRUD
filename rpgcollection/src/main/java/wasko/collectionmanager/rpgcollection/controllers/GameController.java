package wasko.collectionmanager.rpgcollection.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wasko.collectionmanager.rpgcollection.dto.Game;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;
import wasko.collectionmanager.rpgcollection.services.GameService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game")
@AllArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getGames(){
        List<Game> games = gameService.getGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") Long id){
        Game game = gameService.findGameById(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
    @GetMapping("/byPublisher/{id}")
    public ResponseEntity<List<Game>> getGameByPublisherId(@PathVariable("id") Long id){
        List<Game> games = gameService.findGamesByPublisherId(id);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/byUser/{id}")
    public ResponseEntity<List<Game>> getGameByUserId(@PathVariable("id") Long id){
        List<Game> games = gameService.findGamesByUserId(id);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/byAuthor")
    public ResponseEntity<List<Game>> getGameByAuthor(@RequestParam String author){
        List<Game> games = gameService.findGamesByAuthor(author);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/byGenre")
    public ResponseEntity<List<Game>> getGameByGenre(@RequestParam String genre){
        List<Game> games = gameService.findGamesByGenre(genre);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/byCategory")
    public ResponseEntity<List<Game>> getGameByCategory(@RequestParam String category){
        List<Game> games = gameService.findGamesByCategory(category);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<GameEntity> addGame(@Valid @RequestBody Game game){

        return new ResponseEntity<>(gameService.addGame(game), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameEntity> updateGame(@RequestBody Game game, @PathVariable("id") Long id){
        return new ResponseEntity<>(gameService.updateGame(game, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable("id") Long id){
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
