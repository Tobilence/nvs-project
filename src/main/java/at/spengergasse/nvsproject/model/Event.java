package at.spengergasse.nvsproject.model;

import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The event model
 * This model defines which data is saved for the event object - it is an exact replica of the event database table
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Event")
public class Event extends AbstractPersistable<Long> {

    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "date")
    private LocalDate date;
    @ManyToOne (cascade = CascadeType.MERGE)
    private Calendar calendar;

    public Event(EventDto eventDto){
        setId(eventDto.getId());
        this.name = eventDto.getName();
        this.description = eventDto.getDetails();
        this.date = LocalDate.parse(eventDto.getStart(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.calendar = eventDto.getCalendar();
    }
}
