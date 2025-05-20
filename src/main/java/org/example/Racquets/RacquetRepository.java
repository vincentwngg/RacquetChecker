package org.example.Racquets;

import org.example.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacquetRepository extends JpaRepository<User, Long> {

}
