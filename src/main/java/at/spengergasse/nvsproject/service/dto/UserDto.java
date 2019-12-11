package at.spengergasse.nvsproject.service.dto;

import at.spengergasse.nvsproject.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private CalendarDto calendar;

    public UserDto(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.calendar = Optional.ofNullable(user.getCalendar()).map(CalendarDto::new).get();
    }
}
