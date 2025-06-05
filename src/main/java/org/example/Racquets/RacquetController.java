package org.example.Racquets;

import org.example.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RacquetController {

    private static final String success = "{\"message\":\"success\"}";
    private static final String failure = "{\"message\":\"failure\"}";

    @Autowired
    RacquetRepository racquetRepository;

    public RacquetController(RacquetRepository racquetRepository){
        this.racquetRepository = racquetRepository;
    }

    @GetMapping(path = "/racquets")
    public ResponseEntity<List<Racquet>> getAllRacquets(){
        return ResponseEntity.ok(racquetRepository.findAll());
    }

    @PostMapping(path = "/racquets/add")
    public ResponseEntity<String> addRacquet(@RequestBody Racquet racquet){
        if(racquet == null){
            return ResponseEntity.badRequest().body(failure);
        }

        try{
            racquetRepository.save(racquet);

            return ResponseEntity.ok(success);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(failure);
        }
    }

    @DeleteMapping(path = "/racquets/delete/{id}")
    public ResponseEntity<String> deleteRacquet(@PathVariable Long id){
        if(racquetRepository.findById(id).isPresent()){
            racquetRepository.deleteById(id);
            return ResponseEntity.ok(success);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failure);
    }





}
