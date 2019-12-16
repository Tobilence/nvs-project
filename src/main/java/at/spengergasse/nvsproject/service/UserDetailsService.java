package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.model.User;
import at.spengergasse.nvsproject.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The implementation of the authentication
 */
@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s)
                        .orElseThrow(() -> new UsernameNotFoundException("Could not find Username " + s));
        return new UserPrincipal(user);
    }
}
