package org.example.Listings;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 *
 * @author Vincent Wang
 *
 */
@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {


}
