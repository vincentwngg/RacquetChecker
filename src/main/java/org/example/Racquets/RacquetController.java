package org.example.Racquets;

import org.example.Users.User;
import org.example.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/racquets/{id}")
    public ResponseEntity<Racquet> getRacquetById(@PathVariable Long id) {
        return racquetRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/racquets/search")
    public ResponseEntity<List<Racquet>> searchRacquets(@RequestParam String keyword) {
        List<Racquet> results = racquetRepository.findByBrandContainingIgnoreCaseOrModelContainingIgnoreCase(keyword, keyword);
        return ResponseEntity.ok(results);
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

    @PutMapping(path = "/racquets/update/{id}")
    public ResponseEntity<Racquet> updateRacquet(@PathVariable Long id, @RequestBody Racquet request){
        Optional<Racquet> racquet = racquetRepository.findById(id);

        if(racquet.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().body(null);
        }

        Racquet newRacquet = racquet.get();
        newRacquet.setBrand(request.getBrand());
        newRacquet.setModel(request.getModel());
        newRacquet.setPrice(request.getPrice());
        newRacquet.setSpecs(request.getSpecs());

        Racquet updatedRacquet = racquetRepository.save(newRacquet);
        return ResponseEntity.ok(updatedRacquet);
    }




}
