package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.UserService;
import at.spengergasse.nvsproject.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The User Controller
 * This class defines all the available url's that involve user objects
 */
@Controller
@RequestMapping (path = "/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    /**
     * @return the user object with the given id
     */
    @GetMapping (path = "/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    /**
     * @return all UserObjects
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    /**
     * saves a user Object
     * @param userDto the arguments of the user object that should be saved
     * @return the new user object
     */
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    /**
     * @param id the id of the user object that should be deleted
     */
    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(200).build();
    }
}
