package at.spengergasse.nvsproject.presentation;

import at.spengergasse.nvsproject.service.EventService;
import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The Event Controller
 * This class defines all the available url's that involve event objects
 */
@Controller
@RequiredArgsConstructor
@RequestMapping (path = "/events")
@CrossOrigin
public class EventController {

    private final EventService eventService;

    /**
     * @return the event with the given id
     */
    @GetMapping (path = "/{id}")
    public ResponseEntity<EventDto> findEventById(@PathVariable Long id){
        return ResponseEntity.ok(
                eventService.findEventById(id)
        );
    }

    /**
     * @return all events in the database
     */
    @GetMapping
    public ResponseEntity<List<EventDto>> findAllEvents(){
        return ResponseEntity.ok(
                eventService.findAllEvents()
        );
    }

    /**
     * Saves (insert if no id is provided, update if there already is an event object with that id) an event object
     * @param eventDto The event object that should be saved
     * @return the new event object (with the exact attributes is currently has in the database)
     */
    @PostMapping
    public ResponseEntity<EventDto> saveEvent(@RequestBody EventDto eventDto){
        return ResponseEntity.ok(
                eventService
                        .saveEvent(eventDto)
        );
    }

    /**
     * Deletes an event
     * @param id the id of the event that should be deleted
     */
    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        eventService.deleteEventById(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping (params = {"calendarId"})
    public ResponseEntity<List<EventDto>> findEventsForCalendar(@RequestParam Long calendarId){
        return ResponseEntity.ok(eventService.findForCalendar(calendarId));
    }

    @PostMapping (path = "/{id}")
    public ResponseEntity<EventDto> updateEventDetails(@PathVariable Long id, @RequestBody String details) {
        return ResponseEntity.ok(eventService.updateDetails(id, details));
    }

































}
