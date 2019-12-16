package at.spengergasse.nvsproject.service.dto;

import at.spengergasse.nvsproject.model.Calendar;
import at.spengergasse.nvsproject.model.Event;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

/**
 * The Data Transfer Object of the event model
 */
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class EventDto {

    private Long id;
    private String name;
    private String description;
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private Calendar calendar;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    /**
     * Initializes the dto with the data of the given event
     */
    public EventDto(Event event){
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.startDateTime = event.getStartDateTime();
        this.endDateTime = event.getEndDateTime();
    }
}
