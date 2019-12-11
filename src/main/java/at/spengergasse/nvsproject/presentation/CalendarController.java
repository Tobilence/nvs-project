package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.CalendarService;
import at.spengergasse.nvsproject.service.dto.CalendarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping (path = "/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping (params = "userId")
    public ResponseEntity<CalendarDto> findCalendarForUser(@RequestParam (name = "userId") Long userId) {
        return ResponseEntity.ok(calendarService.findCalendarForUserId(userId));
    }

}
