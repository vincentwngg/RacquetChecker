package org.example.Users;

import org.example.Passwords.Password;
import org.example.Passwords.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @PostMapping(path = "users/signup")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        if(user == null){
            return ResponseEntity.badRequest().body(failure);
        }
        userRepository.save(user);
        return ResponseEntity.ok(success);
    }

    @PostMapping("users/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Optional<User> userOpt = userRepository.findByUserName(username);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("success", false, "message", "User not found"));
        }

        User user = userOpt.get();
        Password storedPassword = user.getPassword();

        try {
            String inputHash = Password.hashPassword(password, storedPassword.getSalt());

            if (storedPassword.getHashedPassword().equals(inputHash)) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "userId", user.getId(),
                        "username", user.getUsername()
                ));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("success", false, "message", "Invalid credentials"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", "Login error"));
        }
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
