package org.example.Listings;

import org.example.Racquets.Racquet;
import org.example.Racquets.RacquetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListingController {

    private static final String success = "{\"message\":\"success\"}";
    private static final String failure = "{\"message\":\"failure\"}";

    @Autowired
    ListingRepository listingRepository;

    public ListingController(ListingRepository listingRepository){
        this.listingRepository = listingRepository;
    }

    @GetMapping(path = "/listings")
    public ResponseEntity<List<Listing>> getAllListings(){
        return ResponseEntity.ok(listingRepository.findAll());
    }
}
