package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.UserService;
import at.spengergasse.nvsproject.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping (path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping (path = "/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(200).build();
    }
}
