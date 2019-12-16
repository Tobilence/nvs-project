package at.spengergasse.nvsproject.persistence;

import at.spengergasse.nvsproject.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Event Repository
 * This class handles all the database access related to the event table
 * It has basic CRUD methods
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
