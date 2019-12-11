package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.model.User;
import at.spengergasse.nvsproject.persistence.CalendarRepository;
import at.spengergasse.nvsproject.persistence.EventRepository;
import at.spengergasse.nvsproject.persistence.UserRepository;
import at.spengergasse.nvsproject.service.dto.CalendarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;
    private final UserRepository userRepository;

    public CalendarDto findCalendarForUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id: " + userId + " not found"));
        return Optional.of(
                calendarRepository
                        .findByUsers(user)
                )
                .map(CalendarDto::new)
                .get();
    }
}
