package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.exception.AuthenticationException;
import at.spengergasse.nvsproject.service.UserService;
import at.spengergasse.nvsproject.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    private final UserService userService;

    @PostMapping(path = "/authentication")
    public ResponseEntity<UserDto> basicAuthentication(@RequestBody UserDto userDto){
        try {
            return ResponseEntity.ok(userService.checkCredentials(userDto));
        } catch (AuthenticationException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
