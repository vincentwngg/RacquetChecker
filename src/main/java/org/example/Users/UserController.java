package org.example.Users;

import org.example.Passwords.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordRepository passwordRepository;

    private static final String success = "{\"message\":\"success\"}";
    private static final String failure = "{\"message\":\"failure\"}";

    public UserController(UserRepository userRepository, PasswordRepository passwordRepository) {
        this.userRepository = userRepository;
        this.passwordRepository = passwordRepository;
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping(path = "users/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        if(user == null){
            return ResponseEntity.badRequest().body(failure);
        }
        userRepository.save(user);
        return ResponseEntity.ok(success);
    }

    @DeleteMapping(path = "users/delete/{id}")
    public ResponseEntity<String> deleteUser(@RequestBody Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok(success);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failure);
    }







}
