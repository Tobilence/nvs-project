package at.spengergasse.nvsproject.persistence;

import at.spengergasse.nvsproject.model.Calendar;
import at.spengergasse.nvsproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    Calendar findByUsers(User user);
}
