package org.example.Passwords;


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
public interface PasswordRepository extends JpaRepository<Password, Long> {


}
