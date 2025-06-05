package org.example.Racquets;

import org.example.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacquetRepository extends JpaRepository<Racquet, Long> {
    List<Racquet> findByBrandContainingIgnoreCaseOrModelContainingIgnoreCase(String brand, String model);
}
