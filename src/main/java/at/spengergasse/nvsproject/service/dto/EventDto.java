package at.spengergasse.nvsproject.service.dto;

import at.spengergasse.nvsproject.model.Event;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDto {

    private String name;
    private LocalDateTime dateTime;
    private int duration;

    public EventDto(Event event){
        this.name = event.getName();
        this.dateTime = event.getDateTime();
        this.duration = event.getDuration();
    }
}
