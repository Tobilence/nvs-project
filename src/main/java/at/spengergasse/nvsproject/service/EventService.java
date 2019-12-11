package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.model.Event;
import at.spengergasse.nvsproject.persistence.EventRepository;
import at.spengergasse.nvsproject.service.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<EventDto> findAllEvents(){
        return eventRepository
                .findAll()
                .stream()
                .map(EventDto::new)
                .collect(Collectors.toList());
    }

    public EventDto findEventById(Long id) {
        return eventRepository
                .findById(id)
                .map(EventDto::new)
                .get();
    }

    public EventDto saveEvent(EventDto eventDto){
        Event event = Optional.of(eventDto).map(Event::new).get();

        return Optional.of(
                    eventRepository.save(event)
                )
                .map(EventDto::new).get();
    }

    public void deleteEventById(Long id){
        eventRepository.deleteById(id);
    }
}
