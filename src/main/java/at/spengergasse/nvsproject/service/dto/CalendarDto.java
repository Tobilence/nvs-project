package at.spengergasse.nvsproject.service.dto;

import at.spengergasse.nvsproject.model.Calendar;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CalendarDto {

    private String name;
    private List<EventDto> events;

    public CalendarDto(Calendar calendar){
        this.name = calendar.getName();
        this.events = calendar.getEvents().stream().map(EventDto::new).collect(Collectors.toList());
    }
}
