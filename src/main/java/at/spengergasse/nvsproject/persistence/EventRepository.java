package at.spengergasse.nvsproject.persistence;

import at.spengergasse.nvsproject.model.Calendar;
import at.spengergasse.nvsproject.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The Event Repository
 * This class handles all the database access related to the event table
 * It has basic CRUD methods
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
