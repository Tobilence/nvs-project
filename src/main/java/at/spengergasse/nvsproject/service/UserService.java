package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.exception.AuthenticationException;
import at.spengergasse.nvsproject.exception.PersistenceException;
import at.spengergasse.nvsproject.model.User;
import at.spengergasse.nvsproject.persistence.UserRepository;
import at.spengergasse.nvsproject.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The User Service
 * This class is responsible for all the logic involving user objects
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Maps the UserDto to a user, encrypts the password and then saves it to the Database
     *      if the username doesn't already exist
     * @param userDto The UserDto which is equivalent to the JSON given into the Controller
     *                - the controller simply passes it to this class
     * @return A new UserDto. This UserDto also has an id (since the Database gave it one)
     */
    public UserDto saveUser(UserDto userDto){
        userRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new PersistenceException("This Username already exists: " + userDto.getUsername()));

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = Optional.of(userDto)
                .map(User::new)
                .get();


        return Optional.of(
                    userRepository.save(user)
                )
                .map(UserDto::new)
                .get();
    }

    public UserDto checkCredentials(UserDto userDto) throws AuthenticationException{
         User expectedUser = userRepository.findByUsername(userDto.getUsername())
                 .orElseThrow(() -> new AuthenticationException("Username not found " + userDto.getUsername()));

         if(passwordEncoder.matches(userDto.getPassword(), expectedUser.getPassword())){
             return Optional.of(expectedUser).map(UserDto::new).get();
         }
         else {
             throw new AuthenticationException("The username and password don't match");
         }
    }

    /**
     * @return All users (mapped to UserDto's) from the Database.
     */
    public List<UserDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    /**
     * @param id the id of the wanted user
     * @return The user with the given id
     */
    public UserDto findById(Long id) {
        return userRepository
                .findById(id)
                .map(UserDto::new)
                .get();
    }

    /**
     * Deletes the user with the given id
     * @param id the id of the user that should be deleted
     */
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}


