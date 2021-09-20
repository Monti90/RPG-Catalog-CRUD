package wasko.collectionmanager.rpgcollection.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wasko.collectionmanager.rpgcollection.dto.GamePublisher;
import wasko.collectionmanager.rpgcollection.entities.GamePublisherEntity;
import wasko.collectionmanager.rpgcollection.services.GamePublisherService;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@AllArgsConstructor
public class GamePublisherController {
    private final GamePublisherService gamePublisherService;


    @GetMapping
    public ResponseEntity<List<GamePublisher>> getPublishers(){
        return new ResponseEntity<>(gamePublisherService.getPublishers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GamePublisherEntity> getPublisherById(@PathVariable("id") Long id){
        return new ResponseEntity<>(gamePublisherService.findPublisherById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GamePublisherEntity> addPublisher(@RequestBody GamePublisher gamePublisher){
        return new ResponseEntity<>(gamePublisherService.addPublisher(gamePublisher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GamePublisherEntity> updatePublisher(@RequestBody GamePublisher publisher, @PathVariable("id") Long id){
        return new ResponseEntity<>(gamePublisherService.updatePublisher(publisher, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable("id") Long id){
        gamePublisherService.deletePublisher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
