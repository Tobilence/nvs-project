package at.spengergasse.nvsproject.service.dto;

import at.spengergasse.nvsproject.model.Calendar;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The Data Transfer Object of the calendar model
 */
@Getter
@Setter
@NoArgsConstructor
public class CalendarDto {

    private Long id;
    private String name;
    private List<EventDto> events;

    /**
     * Initializes the dto with the data of the given calendar
     */
    public CalendarDto(Calendar calendar){
        this.id = calendar.getId();
        this.name = calendar.getName();
        this.events = calendar.getEvents().stream().map(EventDto::new).collect(Collectors.toList());
    }
}
