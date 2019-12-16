package at.spengergasse.nvsproject.persistence;

import at.spengergasse.nvsproject.model.Calendar;
import at.spengergasse.nvsproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Calendar Repository
 * This class handles all the database access related to the calendar table
 * It has basic CRUD methods
 */
@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    /**
     * Custom method
     * @return the calendar that belongs to the given user
     */
    Calendar findByUsers(User user);
}
