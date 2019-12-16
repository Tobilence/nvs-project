package at.spengergasse.nvsproject.persistence;

import at.spengergasse.nvsproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The User Repository
 * THis class handles all the database access related to the user table
 * It has basic CRUD methods
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * finds a user by the Username
     * @return An optional value opf the User (Optional is empty if there is no user with the given username)
     */
    Optional<User> findByUsername(String username);
}
