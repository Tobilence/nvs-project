package at.spengergasse.nvsproject.service.dto;

import at.spengergasse.nvsproject.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Optional;

/**
 * The Data Transfer Object of the user model
 */
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private CalendarDto calendar;

    /**
     * Initializes the dto with the data of the given user
     */
    public UserDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.calendar = Optional.ofNullable(user.getCalendar()).map(CalendarDto::new).get();
    }
}
