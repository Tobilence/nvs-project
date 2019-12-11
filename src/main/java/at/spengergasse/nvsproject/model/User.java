package at.spengergasse.nvsproject.model;

import at.spengergasse.nvsproject.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "User")
public class User extends AbstractPersistable<Long> {

    @Column (name = "username")
    private String username;
    @Column (name = "password")
    private String password;
    @Column (name = "email")
    private String email;
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Calendar calendar;

    public User(UserDto userDto) {
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.calendar = Optional.ofNullable(userDto.getCalendar()).map(Calendar::new).orElse(null);
    }
}

