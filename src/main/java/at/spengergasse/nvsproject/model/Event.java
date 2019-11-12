package at.spengergasse.nvsproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Event")
public class Event extends AbstractPersistable<Long> {

    @Column (name = "name")
    private String name;
    @Column (name = "date_time")
    private LocalDateTime dateTime;
    @Column (name = "duration")
    private int duration;
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Calendar calendar;
}
