package wasko.collectionmanager.rpgcollection.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wasko.collectionmanager.rpgcollection.dto.User;
import wasko.collectionmanager.rpgcollection.entities.UserEntity;
import wasko.collectionmanager.rpgcollection.services.UserService;
import wasko.collectionmanager.rpgcollection.view.UserWithoutPasswordView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserWithoutPasswordView> getUserById(@PathVariable("id") Long id){
            return new ResponseEntity<>(userService.findUserViewById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserEntity> addUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody User user, @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
