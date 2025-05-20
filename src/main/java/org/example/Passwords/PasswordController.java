package org.example.Passwords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PasswordController {

    @Autowired
    PasswordRepository passwordRepository;


    @PutMapping(path = "/passwords/{id}")
    public ResponseEntity<Password> updatePassword(@PathVariable int id, @RequestBody Password request){
        Optional<Password> passwordOptional = passwordRepository.findById(Long.valueOf(id));

        if (passwordOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Password password = passwordOptional.get();
        if(password == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (request.getId() != id) {
            return ResponseEntity.badRequest().body(null);
        }
        passwordRepository.save(request);
        return ResponseEntity.ok(password);
    }
}
