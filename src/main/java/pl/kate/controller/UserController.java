package pl.kate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kate.entity.User;
import pl.kate.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> readAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping
    public ResponseEntity<Optional<User>> getUserId(int id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User toCreateUser){
        User result = userService.save(toCreateUser);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

}
