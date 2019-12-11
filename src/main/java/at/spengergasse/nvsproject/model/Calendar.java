package at.spengergasse.nvsproject.model;

import at.spengergasse.nvsproject.service.dto.CalendarDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Calendar")
public class Calendar extends AbstractPersistable<Long> {

    @Column (name = "name")
    private String name;
    @OneToMany (mappedBy = "calendar")
    private List<Event> events;
    @Transient
    private List<Holiday> holidays;
    @OneToMany (mappedBy = "calendar")
    private List<User> users;

    public Calendar(CalendarDto calendarDto){
        this.name = calendarDto.getName();
        this.events = Optional.ofNullable(calendarDto.getEvents())
                .orElse(new ArrayList<>())
                .stream()
                .map(Event::new)
                .collect(Collectors.toList());
    }
}
