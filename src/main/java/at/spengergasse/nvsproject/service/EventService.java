package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.model.Event;
import at.spengergasse.nvsproject.persistence.CalendarRepository;
import at.spengergasse.nvsproject.persistence.EventRepository;
import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The Event Service
 * This class handles all the logic related to event objects
 */
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final CalendarRepository calendarRepository;

    /**
     * @return A list of all Events mapped to Dto's
     */
    public List<EventDto> findAllEvents(){
        return eventRepository
                .findAll()
                .stream()
                .map(EventDto::new)
                .collect(Collectors.toList());
    }

    /**
     * @return The event with the given id mapped to a Dto
     */
    public EventDto findEventById(Long id) {
        return eventRepository
                .findById(id)
                .map(EventDto::new)
                .get();
    }

    /**
     * Saves the given event
     * @param eventDto the dto of the event that should be saved
     * @return the new event
     */
    public EventDto saveEvent(EventDto eventDto){
        Event event = Optional.of(eventDto).map(Event::new).get();
        return Optional.of(
                    eventRepository.save(event)
                )
                .map(EventDto::new).get();
    }

    /**
     * @param id the id of the event that should be deleted
     */
    public void deleteEventById(Long id){
        eventRepository.deleteById(id);
    }
}
