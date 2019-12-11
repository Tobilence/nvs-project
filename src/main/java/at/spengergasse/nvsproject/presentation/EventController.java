package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.EventService;
import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping (path = "/events")
public class EventController {

    private final EventService eventService;

    @GetMapping (path = "/{id}")
    public ResponseEntity<EventDto> findEventById(@PathVariable Long id){
        return ResponseEntity.ok(
                eventService.findEventById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> findAllEvents(){
        return ResponseEntity.ok(
                eventService.findAllEvents()
        );
    }

    @PostMapping
    public ResponseEntity<EventDto> saveEvent(@RequestBody EventDto eventDto){
        return ResponseEntity.ok(
                eventService
                        .saveEvent(eventDto)
        );
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        eventService.deleteEventById(id);
        return ResponseEntity.status(200).build();
    }
}
