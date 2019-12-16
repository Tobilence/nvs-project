package at.spengergasse.nvsproject.model;

import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column (name = "start_date_time")
    private LocalDateTime startDateTime;
    @Column (name = "end_date_time")
    private LocalDateTime endDateTime;
    @ManyToOne (cascade = CascadeType.MERGE)
    private Calendar calendar;

    public Event(EventDto eventDto){
        this.name = eventDto.getName();
        this.description = eventDto.getDescription();
        this.startDateTime = eventDto.getStartDateTime();
        this.endDateTime = eventDto.getEndDateTime();
        this.calendar = eventDto.getCalendar();
    }
}
