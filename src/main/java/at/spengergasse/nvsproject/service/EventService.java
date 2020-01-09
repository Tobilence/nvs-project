package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.exception.PersistenceException;
import at.spengergasse.nvsproject.model.Event;
import at.spengergasse.nvsproject.persistence.CalendarRepository;
import at.spengergasse.nvsproject.persistence.EventRepository;
import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    /**
     * filters all events to the ones needed
     * @param start the earlier date
     * @param end the later date
     * @param calendarId the calendar
     * @return all dates between start and end that have the given calendarId
     */
    public List<EventDto> findBetween(LocalDate start, LocalDate end, Long calendarId) {

        return eventRepository.findAll()
                .stream()
                .filter(event ->
                            Objects.equals(event.getCalendar().getId(), calendarId)
                            && event.getDate().isAfter(start)
                            && event.getDate().isBefore(end))
                .map(EventDto::new)
                .collect(Collectors.toList());
    }

    public EventDto updateDetails(Long id, String details) {

        EventDto eventDto =
                Optional.of(
                        eventRepository.findById(id)
                            .orElseThrow(() -> new PersistenceException("No event found with id: " + id))
                )
                .map(EventDto::new)
                .get();

        eventDto.setDetails(details);

        return Optional.of(
                eventRepository.save(
                        Optional.of(eventDto)
                                .map(Event::new)
                                .get())
                )
                .map(EventDto::new)
                .get();
    }

    public List<EventDto> findForCalendar(Long calendarId) {
        return eventRepository.findAll()
                .stream()
                .filter(event -> calendarId.equals(event.getCalendar().getId()))
                .map(EventDto::new)
                .collect(Collectors.toList());
    }
}
