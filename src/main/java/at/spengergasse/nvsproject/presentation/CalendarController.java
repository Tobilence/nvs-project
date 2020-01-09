package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.CalendarService;
import at.spengergasse.nvsproject.service.dto.CalendarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Calendar Controller
 * This class defines all the available url's that involve calendar objects
 */
@Controller
@RequiredArgsConstructor
@RequestMapping (path = "/calendars")
@CrossOrigin
public class CalendarController {

    private final CalendarService calendarService;

    /**
     * @return The Calendar object that belongs to the user with the given userId
     */
    @GetMapping (params = "userId")
    public ResponseEntity<CalendarDto> findCalendarForUser(@RequestParam (name = "userId") Long userId) {
        return ResponseEntity.ok(calendarService.findCalendarForUserId(userId));
    }
}
