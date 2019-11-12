package at.spengergasse.nvsproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class Calendar extends AbstractPersistable<Long> {

    @Column (name = "name")
    private String name;
    @OneToMany (mappedBy = "calendar")
    private List<Event> events;
    @Transient
    private List<Holiday> holidays;
    @OneToMany (mappedBy = "calendar")
    private List<User> users;
}
