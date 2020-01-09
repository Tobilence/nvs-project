package at.spengergasse.nvsproject.service.dto;

import at.spengergasse.nvsproject.model.Calendar;
import at.spengergasse.nvsproject.model.Event;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private String details;
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private Calendar calendar;
    private String start;

    /**
     * Initializes the dto with the data of the given event
     */
    public EventDto(Event event){
        this.id = event.getId();
        this.name = event.getName();
        this.details = event.getDescription();
        this.start = event.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
