package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.EventService;
import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping (path = "/events")
    public ResponseEntity<List<EventDto>> findAllEvents(){
        return ResponseEntity.ok(eventService.findAllEvents());
    }
}
